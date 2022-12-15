package pl.coderslab.dogmeat.character.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogmeat.armor.service.ArmorService;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.mutation.entity.Mutation;
import pl.coderslab.dogmeat.mutation.service.MutationService;
import pl.coderslab.dogmeat.talent.entity.Talent;
import pl.coderslab.dogmeat.talent.service.TalentService;
import pl.coderslab.dogmeat.user.entity.User;
import pl.coderslab.dogmeat.user.service.CurrentUser;
import pl.coderslab.dogmeat.weapon.entity.Weapon;
import pl.coderslab.dogmeat.weapon.enums.WeaponRange;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserCharacterController {

    private final CharacterService characterService;
    private final MutationService mutationService;
    private final TalentService talentService;
    private final ArmorService armorService;



    @ModelAttribute("rolesList")
    public CharacterRole[] getRolesList() {
        CharacterRole[] values = CharacterRole.values();
        return values;
    }

    @ModelAttribute("rangeList")
    public WeaponRange[] getWeaponRangeList() {
        WeaponRange[] values = WeaponRange.values();
        return values;
    }

    @ModelAttribute("mutationList")
    public List<Mutation> getMutationList() {
        return mutationService.allMutations();
    }

    @ModelAttribute("talentList")
    public List<Talent> getAllTalents() {
        return talentService.allTalents();
    }

    @RequestMapping("/character/details/{mCharId}")
    public String characterDetails(@AuthenticationPrincipal CurrentUser currentUser,
                                   @PathVariable("mCharId") long id, Model model) {
        User user = currentUser.getUser();

        MCharacter mChar = characterService.findMCharacterById(id);

        if (mChar == null) {
            return "redirect:/user/list";
        }


        List<Long> charactersIds = characterService.findMcharactersIdByUserId(user.getId());
        model.addAttribute("eqList", mChar.getEquipment());
        model.addAttribute("weaponList", mChar.getWeapons());
        model.addAttribute("mCharDetails", mChar);
        model.addAttribute("eq", new Equipment());
        model.addAttribute("weapon", new Weapon());

        if (charactersIds.contains(id) || characterService.isGm(user, mChar)) {

            return ("user/character/characterdetails");
        } else {

            return ("user/character/characterdetailsreadonly");
        }


    }


    @RequestMapping("/character/delete/{mCharId}/confirm")
    public String confirmDelete(@PathVariable("mCharId") long id) {

        return ("/user/confirmdelete");
    }

    @RequestMapping("/character/details/delete/{mCharId}")
    public String deleteCharacter(@AuthenticationPrincipal CurrentUser currentUser,
                                  @PathVariable("mCharId") long id) {
        User user = currentUser.getUser();
        List<Long> charactersIds = characterService.findMcharactersIdByUserId(user.getId());
        if (charactersIds.contains(id)) {

            characterService.deleteMCharacterById(id);
        } else {
            return ("errors/403");
        }

        return ("redirect:/user/list");
    }

    @GetMapping("/character/new")
    public String newCharacter(Model model) {
        model.addAttribute("mChar", new MCharacter());

        return ("user/character/characternew");

    }


    @PostMapping("/character/sheet")
    public String saveNewCharacter(
            @AuthenticationPrincipal CurrentUser currentUser,
            Model model,
            @ModelAttribute("eq") Equipment eq,
            @ModelAttribute("mCharDetails") MCharacter mCharacterDetails,
            @ModelAttribute("weapon") Weapon weapon) {

        Set<Mutation> mutationList;
        Set<Talent> talentList;

        if (mCharacterDetails.getId() != null) {
            model.addAttribute("eqList", characterService.findMCharacterById(mCharacterDetails.getId()).getEquipment());
            model.addAttribute("weaponList", characterService.findMCharacterById(mCharacterDetails.getId()).getWeapons());
            MCharacter carrier = characterService.findMCharacterById(mCharacterDetails.getId());
            mCharacterDetails.setName(carrier.getName());
            mCharacterDetails.setProfession(carrier.getProfession());
            mCharacterDetails.setUser(carrier.getUser());
            mCharacterDetails.setEquipment(carrier.getEquipment());
            mCharacterDetails.setWeapons(carrier.getWeapons());
            mutationList = mCharacterDetails.getMutations();
            mutationList.addAll(carrier.getMutations());
            talentList = mCharacterDetails.getTalents();
            talentList.addAll(carrier.getTalents());


            if (carrier.getArmor() == null) {
                armorService.saveArmor(mCharacterDetails.getArmor());
            } else {
                mCharacterDetails.getArmor().setId(carrier.getArmor().getId());
                armorService.saveArmor(mCharacterDetails.getArmor());
            }

            characterService.save(mCharacterDetails);
            model.addAttribute("mCharDetails", mCharacterDetails);
            return ("redirect:/user/character/details/" + mCharacterDetails.getId());
        }
        mCharacterDetails.setUser(currentUser.getUser());
        characterService.save(mCharacterDetails);
        model.addAttribute("mCharDetails", mCharacterDetails);


        return ("redirect:/user/character/details/" + mCharacterDetails.getId());
    }

}
