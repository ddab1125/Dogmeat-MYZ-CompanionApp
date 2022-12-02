package pl.coderslab.dogmeat.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.dogmeat.character.dto.SimpleMCharacterDto;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;
import pl.coderslab.dogmeat.character.mapper.MCharacterMapper;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.service.EquipmentService;
import pl.coderslab.dogmeat.user.service.CurrentUser;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CharacterRepository characterRepository;
    private final EquipmentService equipmentService;



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
        model.addAttribute("eqList", characterRepository.findMCharacterById(id).getEquipment());
        model.addAttribute("mCharDetails", characterRepository.findMCharacterById(id));
        model.addAttribute("eq", new Equipment());

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
    public String saveNewCharacter(MCharacter mChar,
                                   @AuthenticationPrincipal CurrentUser currentUser,
                                   Model model,
                                   @ModelAttribute("eq") Equipment eq,
                                   @ModelAttribute("mCharDetails") MCharacter mCharacterDetails) {

        List<Equipment> equipmentList;

        if (mChar.getId() != null) {
            model.addAttribute("eqList", characterRepository.findMCharacterById(mChar.getId()).getEquipment());
            MCharacter carrier = characterRepository.findMCharacterById(mChar.getId());
            mChar.setName(carrier.getName());
            mChar.setProfession(carrier.getProfession());
            mChar.setUser(currentUser.getUser());
            mChar.setEquipment(carrier.getEquipment());
            characterRepository.save(mChar);
            model.addAttribute("mCharDetails", mChar);
            return ("/user/characterdetails");
        }
        model.addAttribute("eqList", equipmentList = new ArrayList<>());
        mChar.setUser(currentUser.getUser());
        characterRepository.save(mChar);
        model.addAttribute("mCharDetails", mChar);

        return ("/user/characterdetails");
    }


    @PostMapping("/character/equipment")
    public String saveEqItem(@ModelAttribute("eq") Equipment eq,
                             @ModelAttribute("mCharDetails") MCharacter mCharacterDetails,
                             Model model,
                             @RequestParam Long mCharId) {

        MCharacter mCharacter = characterRepository.findMCharacterById(mCharId);
        model.addAttribute("eqList", characterRepository.findMCharacterById(mCharId).getEquipment());
        model.addAttribute("mCharDetails", mCharacter);
        List<Equipment> equipmentList;

        if (mCharacter.getEquipment() == null) {
            equipmentList = new ArrayList<>();

        } else {
            equipmentList = mCharacter.getEquipment();
        }
        equipmentList.add(eq);
        equipmentService.saveItem(eq);
        mCharacter.setEquipment(equipmentList);
        characterRepository.save(mCharacter);

        return ("/user/characterdetails");
    }


}
