package pl.coderslab.dogmeat.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.dogmeat.character.SimpleMCharacterDto;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;
import pl.coderslab.dogmeat.character.mapper.MCharacterMapper;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.user.service.CurrentUser;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CharacterRepository characterRepository;
    private final CharacterService characterService;


    @ModelAttribute("mCharacters")
    public List<SimpleMCharacterDto> getSheetList(@AuthenticationPrincipal CurrentUser currentUser) {
        List<SimpleMCharacterDto> sheetList = characterRepository.findMCharacterByUserId(currentUser.getUser().getId()).stream()
                .map(MCharacterMapper.INSTANCE::mCharToMCharDto)
                .toList();
        return sheetList;
    }

    @ModelAttribute("rolesList")
    public CharacterRole[] getRolesList() {
        CharacterRole[] values = CharacterRole.values();
        return values;
    }


    @RequestMapping("/dashboard")
    public String userDashboard() {

        return ("/user/dashboard");
    }

    @RequestMapping("/list")
    public String userCharacterList(Model model) {
        model.getAttribute("mCharacters");
        return ("/user/characterslist");
    }

    @RequestMapping("/character/details/{mCharId}")

    public String characterDetails(@PathVariable("mCharId") long id, Model model) {
        model.addAttribute("mCharDetails", characterRepository.findMCharacterById(id));

        return ("/user/characterdetails");
    }

    @RequestMapping("/character/delete/{mCharId}/confirm")
    public String confirmDelete(@PathVariable("mCharId") long id) {

        return ("/user/confirmdelete");
    }

    @RequestMapping("/character/details/delete/{mCharId}")
    public String deleteCharacter(@PathVariable("mCharId") long id) {
        characterRepository.deleteMCharacterById(id);

        return ("redirect:/user/list");
    }

    @GetMapping("/character/new")
    public String newCharacter(Model model) {
        model.addAttribute("mChar", new MCharacter());

        return ("/fragments/charactersheet");
    }


    @PostMapping("/character/new")
    public String saveNewCharacter(MCharacter mChar, @AuthenticationPrincipal CurrentUser currentUser, Model model) {
        if (mChar.getId() != null) {
            MCharacter carrier = characterRepository.findMCharacterById(mChar.getId());
            mChar.setName(carrier.getName());
            mChar.setProfession(carrier.getProfession());
            mChar.setUser(currentUser.getUser());
            characterRepository.save(mChar);
            model.addAttribute("mCharDetails", mChar);
            return ("/user/characterdetails");
        }

        mChar.setUser(currentUser.getUser());
        characterRepository.save(mChar);

        return ("redirect:/user/list");
    }


}
