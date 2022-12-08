package pl.coderslab.dogmeat.weapon.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.service.EquipmentService;
import pl.coderslab.dogmeat.weapon.entity.Weapon;
import pl.coderslab.dogmeat.weapon.repository.WeaponRepository;

@Service
@Data
public class WeaponService {

    private final WeaponRepository weaponRepository;
    private final EquipmentService equipmentService;

    private final CharacterRepository characterRepository;

    public void saveWeapon(Weapon weapon, MCharacter mCharacter) {
        weaponRepository.save(weapon);
        Equipment equipment = new Equipment();
        weapon.setItem(equipment);
        equipment.setItemName(weapon.getWeaponName());
        equipment.setItemWeight(weapon.getWeaponWeight());
        equipment.setItemQuantity(1);
        equipmentService.saveWeaponItem(equipment, weapon);
        mCharacter.getEquipment().add(equipment);
        characterRepository.save(mCharacter);
        weaponRepository.save(weapon);
    }

    public void deleteWeapon(Weapon weapon) {
        equipmentService.deleteItem(weapon.getItem().getId());
        weaponRepository.delete(weapon);
    }

    public Weapon findWeaponById(long weaponId) {
       return weaponRepository.findWeaponById(weaponId);
    }
}
