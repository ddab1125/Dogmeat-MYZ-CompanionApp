package pl.coderslab.dogmeat.character.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dogmeat.character.entity.MCharacter;

import java.util.List;


@Transactional
public interface CharacterRepository extends JpaRepository<MCharacter, Long> {

    List<MCharacter> findMCharacterByUserId(Long userId);

    @Query("SELECT m.id FROM MCharacter m WHERE m.user.id = ?1")
    List<Long> findMcharactersIdByUserId(Long userId);

    MCharacter findMCharacterById(Long mCharId);


    @Modifying
    void deleteMCharacterById(Long mCharId);




}
