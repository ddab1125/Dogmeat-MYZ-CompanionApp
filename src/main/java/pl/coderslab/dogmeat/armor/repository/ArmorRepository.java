package pl.coderslab.dogmeat.armor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dogmeat.armor.entity.Armor;


@Repository
public interface ArmorRepository extends JpaRepository<Armor, Long> {
}
