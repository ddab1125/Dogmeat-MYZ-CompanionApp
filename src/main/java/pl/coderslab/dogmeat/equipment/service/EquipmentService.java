package pl.coderslab.dogmeat.equipment.service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.repository.EquipmentRepository;
import pl.coderslab.dogmeat.weapon.entity.Weapon;
import pl.coderslab.dogmeat.weapon.repository.WeaponRepository;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final CharacterRepository characterRepository;
    private final WeaponRepository weaponRepository;

    public void saveItem(Equipment equipment) {

        equipmentRepository.save(equipment);

    }

    public void saveWeaponItem(Equipment equipment, Weapon weapon) {
        equipment.setWeapon(weapon);
        equipmentRepository.save(equipment);

    }

    @Modifying
    public void deleteItem(Long id) {
        Equipment itemToDelete = equipmentRepository.findEquipmentById(id);
        Optional<Weapon> weapon = Optional.ofNullable(itemToDelete.getWeapon());

        if (weapon.isEmpty()) {
            equipmentRepository.delete(itemToDelete);

        } else {
            equipmentRepository.delete(itemToDelete);
            weaponRepository.delete(itemToDelete.getWeapon());
        }

    }

    public Equipment findEquipmentById(Long id) {
        return equipmentRepository.findEquipmentById(id);
    }

    public void updateEquipment(Equipment eq, Long id, String itemName, Double itemWeight, Optional<Long> weapon) {
        eq.setId(id);
        eq.setItemName(itemName);
        eq.setItemWeight(itemWeight);
        if (weapon.isEmpty()) {
            eq.setWeapon(null);
        } else {

            eq.setWeapon(weaponRepository.findWeaponById(weapon.get()));
        }
        equipmentRepository.save(eq);
    }
}
