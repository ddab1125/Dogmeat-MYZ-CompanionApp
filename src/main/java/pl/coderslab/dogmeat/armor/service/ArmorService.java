package pl.coderslab.dogmeat.armor.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.armor.entity.Armor;
import pl.coderslab.dogmeat.armor.repository.ArmorRepository;

@Service
@Data
public class ArmorService {

    private final ArmorRepository armorRepository;

    public void saveArmor(Armor armor) {
        armorRepository.save(armor);
    }
}
