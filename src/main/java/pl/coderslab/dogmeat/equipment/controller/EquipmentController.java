package pl.coderslab.dogmeat.equipment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.service.EquipmentService;
import pl.coderslab.dogmeat.mutation.entity.Mutation;
import pl.coderslab.dogmeat.mutation.service.MutationService;
import pl.coderslab.dogmeat.talent.entity.Talent;
import pl.coderslab.dogmeat.talent.service.TalentService;
import pl.coderslab.dogmeat.weapon.entity.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/character/equipment/")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final CharacterService characterService;

    private final MutationService mutationService;
    private final TalentService talentService;



    @ModelAttribute("mutationList")
    public List<Mutation> getMutationList() {
        return mutationService.allMutations();
    }

    @ModelAttribute("talentList")
    public List<Talent> getTalentList() {
        return talentService.allTalents();
    }

    @ModelAttribute("rolesList")
    public CharacterRole[] getRolesList() {
        CharacterRole[] values = CharacterRole.values();
        return values;
    }

    @RequestMapping("/delete/{mCharId}/{itemId}")
    public String deleteItem(@ModelAttribute("eq") Equipment eq,
                             @ModelAttribute("mCharDetails") MCharacter mCharacterDetails,
                             @PathVariable long mCharId, @PathVariable long itemId,
                             Model model) {
        mCharacterDetails = characterService.findMCharacterById(mCharId);
        model.addAttribute("mCharDetails", mCharacterDetails);
        model.addAttribute("weapon", new Weapon());
        model.addAttribute("weaponList", mCharacterDetails.getWeapons());
        equipmentService.deleteItem(itemId);
        model.addAttribute("eqList", mCharacterDetails.getEquipment());

        return ("redirect:/user/character/details/" + mCharId);
    }

@RequestMapping("/update")
    public String updateItems(@ModelAttribute("eq") Equipment eq,
                              @RequestParam Long mCharId,
                              @RequestParam Long id,
                              @RequestParam String itemName,
                              @RequestParam Double itemWeight,
                              @RequestParam Optional<Long> weapon) {
    equipmentService.updateEquipment(eq, id, itemName, itemWeight, weapon );

    return ("redirect:/user/character/details/" + mCharId);
}

    @PostMapping("/add")
    public String saveEqItem(@ModelAttribute("eq") Equipment eq,
                             @RequestParam Long mCharId) {

        MCharacter mCharacter = characterService.findMCharacterById(mCharId);
        List<Equipment> equipmentList;
        if (mCharacter.getEquipment() == null) {
            equipmentList = new ArrayList<>();

        } else {
            equipmentList = mCharacter.getEquipment();
        }
        equipmentList.add(eq);
        equipmentService.saveItem(eq);
        mCharacter.setEquipment(equipmentList);
        characterService.save(mCharacter);

        return ("redirect:/user/character/details/" + mCharId);
    }


}
