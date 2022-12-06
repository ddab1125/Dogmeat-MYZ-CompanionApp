package pl.coderslab.dogmeat.weapon.repository;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dogmeat.weapon.entity.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {

}
