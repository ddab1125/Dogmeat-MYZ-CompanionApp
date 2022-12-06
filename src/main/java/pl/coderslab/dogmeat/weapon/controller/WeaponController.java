package pl.coderslab.dogmeat.weapon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.weapon.entity.Weapon;
import pl.coderslab.dogmeat.weapon.service.WeaponService;

import java.util.List;

@Controller
@RequestMapping("/user/character/weapon")
@RequiredArgsConstructor
public class WeaponController {

    private final WeaponService weaponService;
    private final CharacterRepository characterRepository;

    @PostMapping("/add")
    public String addWeapon(@ModelAttribute("weapon") Weapon weapon,
                            @RequestParam Long mCharId,
                            Model model) {
        MCharacter mCharDetails = characterRepository.findMCharacterById(mCharId);
        List<Weapon> weapons = mCharDetails.getWeapons();
        weapons.add(weapon);
        model.addAttribute("weaponList", weapons);
        weaponService.saveWeapon(weapon, mCharDetails);
        return ("redirect:/user/character/details/" + mCharId);
    }
}
