package pl.coderslab.dogmeat.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.dogmeat.character.SimpleMCharacterDto;
import pl.coderslab.dogmeat.character.mapper.MCharacterMapper;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.user.service.CurrentUser;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CharacterRepository characterRepository;


    @ModelAttribute("mCharacters")
    public List<SimpleMCharacterDto> getSheetList(@AuthenticationPrincipal CurrentUser currentUser) {
        List<SimpleMCharacterDto> sheetList = characterRepository.findMCharacterByUserId(currentUser.getUser().getId()).stream()
                .map(MCharacterMapper.INSTANCE::mCharToMCharDto)
                .toList();
        return sheetList;
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

}
