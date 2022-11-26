package pl.coderslab.dogmeat.character.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dogmeat.character.SimpleMCharacterDto;
import pl.coderslab.dogmeat.character.entity.MCharacter;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface CharacterRepository extends JpaRepository<MCharacter, Long> {

    List<MCharacter> findMCharacterByUserId(Long userid);

    MCharacter findMCharacterById(Long mCharId);

    void deleteMCharacterById(Long mCharId);

}
