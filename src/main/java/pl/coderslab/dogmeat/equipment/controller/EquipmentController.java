package pl.coderslab.dogmeat.equipment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.service.EquipmentService;
import pl.coderslab.dogmeat.mutation.entity.Mutation;
import pl.coderslab.dogmeat.mutation.service.MutationService;

import java.util.List;

@Controller
@RequestMapping("/user/character/equipment/")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final CharacterRepository characterRepository;

    private final MutationService mutationService;

    @ModelAttribute("mutationList")
    public List<Mutation> getMutationList() {
        return mutationService.allMutations();
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
        mCharacterDetails = characterRepository.findMCharacterById(mCharId);
        model.addAttribute("mCharDetails", mCharacterDetails);
        equipmentService.deleteItem(itemId);
        model.addAttribute("eqList", mCharacterDetails.getEquipment());

        return ("/user/characterdetails");
    }

    @RequestMapping("/update")
    public String updateItem(@ModelAttribute("eq") Equipment eq,
                             @ModelAttribute("mCharDetails") MCharacter mCharacterDetails,
                             Model model) {
        System.out.println(model.getAttribute("eq"));
        return ("/user/characterdetails");
    }
}
