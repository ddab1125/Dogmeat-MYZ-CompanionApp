package pl.coderslab.dogmeat.character.service;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.character.util.CharacterNames;
import pl.coderslab.dogmeat.character.util.CharacterDescriptions;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;

import java.util.List;
import java.util.Random;

@Service
@Data
public class CharacterService {


    public MCharacter generateCharacter() {
        CharacterRole[] roles = CharacterRole.values();
        Random random = new Random();
        int[] at = MCharacter.randomAttributes();
        MCharacter mCharacter = new MCharacter(at[0], at[1], at[2], at[3]);
        CharacterRole randomRole = roles[random.nextInt(roles.length)];
        mCharacter.setProfession(String.valueOf(randomRole));
        mCharacter.setName(CharacterNames.getRandomName());
        mCharacter.setDescription(CharacterDescriptions.getRandomDescription());
        return mCharacter;
    }

//    private void addEqToCharacter(MCharacter mCharacter) {
//        Hibernate.initialize(mCharacter.getEquipment());
//    }


}
