package pl.coderslab.dogmeat.character.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dogmeat.character.entity.MCharacter;

import java.util.List;


public interface CharacterRepository extends JpaRepository<MCharacter, Long> {

}
