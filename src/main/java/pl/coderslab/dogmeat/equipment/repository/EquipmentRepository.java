package pl.coderslab.dogmeat.equipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dogmeat.equipment.entity.Equipment;

import java.util.List;

@Repository
@Transactional
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

 Equipment findEquipmentById(Long id);

}
