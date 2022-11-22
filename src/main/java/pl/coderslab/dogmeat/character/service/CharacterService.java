package pl.coderslab.dogmeat.character.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.character.CharacterNames;
import pl.coderslab.dogmeat.character.CharacterDescriptions;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;

import java.util.Random;

@Service
@Data
public class CharacterService {

    public MCharacter generateCharacter() {
        CharacterRole[] roles = CharacterRole.values();
        Random random = new Random();
        MCharacter mCharacter = new MCharacter(random.nextInt(5)+1, random.nextInt(5)+1, random.nextInt(5)+1, random.nextInt(5)+1);
        CharacterRole randomRole = roles[random.nextInt(roles.length)];
        mCharacter.setProfession(randomRole.getRoleName());
        mCharacter.setName(CharacterNames.getRandomName());
        mCharacter.setDescription(CharacterDescriptions.getRandomDescription());
        return mCharacter;
    }
}
