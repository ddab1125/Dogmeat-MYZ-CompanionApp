package pl.coderslab.dogmeat.equipment.service;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.equipment.repository.EquipmentRepository;

@Service
@Data
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final CharacterRepository characterRepository;

    public void saveItem(Equipment equipment) {

        equipmentRepository.save(equipment);
    }
}
