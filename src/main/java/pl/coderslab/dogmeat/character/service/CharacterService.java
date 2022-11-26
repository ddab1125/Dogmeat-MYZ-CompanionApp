package pl.coderslab.dogmeat.character.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.character.util.CharacterNames;
import pl.coderslab.dogmeat.character.util.CharacterDescriptions;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;

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
        mCharacter.setProfession(randomRole.getRoleName());
        mCharacter.setName(CharacterNames.getRandomName());
        mCharacter.setDescription(CharacterDescriptions.getRandomDescription());
        return mCharacter;
    }


}
