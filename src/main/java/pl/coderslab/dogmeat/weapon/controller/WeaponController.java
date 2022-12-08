package pl.coderslab.dogmeat.weapon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/remove/{mCharId}/{weaponId}")
    public String removeWeapon(@PathVariable long mCharId, @PathVariable long weaponId) {
        MCharacter mCharacterDetails = characterRepository.findMCharacterById(mCharId);
        weaponService.deleteWeapon(weaponService.findWeaponById(weaponId));

        return ("redirect:/user/character/details/" + mCharId);
    }
}
