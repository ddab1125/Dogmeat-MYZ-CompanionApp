package pl.coderslab.dogmeat.equipment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.service.EquipmentService;

import java.util.List;

@Controller
@RequestMapping("/user/character/equipment/")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;
    private final CharacterRepository characterRepository;

    @RequestMapping("/delete/{mCharId}/{itemId}")
    public String deleteItem(@ModelAttribute("eq") Equipment eq,
                             @ModelAttribute("mCharDetails") MCharacter mCharacterDetails,
                             @PathVariable long mCharId, @PathVariable long itemId,
                             Model model) {
        mCharacterDetails = characterRepository.findMCharacterById(mCharId);
        model.addAttribute("mCharDetails", mCharacterDetails);
        model.addAttribute("eqList", mCharacterDetails.getEquipment());
        equipmentService.deleteItem(itemId);

        return ("/user/characterdetails");
    }
}
