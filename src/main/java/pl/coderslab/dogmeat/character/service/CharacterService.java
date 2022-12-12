package pl.coderslab.dogmeat.character.service;

import lombok.Data;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.campaign.service.CampaignService;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.character.util.CharacterNames;
import pl.coderslab.dogmeat.character.util.CharacterDescriptions;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.enums.CharacterRole;
import pl.coderslab.dogmeat.user.entity.User;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CampaignService campaignService;

    public List<MCharacter> findMCharacterByUserId(Long userId) {
        return characterRepository.findMCharacterByUserId(userId);
    }
    public List<Long> findMcharactersIdByUserId(Long userId) {
        return characterRepository.findMcharactersIdByUserId(userId);
    }

    public MCharacter findMCharacterById(Long mCharId){
        return characterRepository.findMCharacterById(mCharId);
    }

    public void deleteMCharacterById(Long mCharId){
        characterRepository.deleteMCharacterById(mCharId);
    }

    public void save(MCharacter mCharacter) {
        characterRepository.save(mCharacter);
    }


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

    public boolean isGm(User user, MCharacter mChar) {
        List<Campaign> allGmCampaignsByPlayer = campaignService.findAllGmCampaignsByPlayer(user.getId());
        Set<Boolean> booleans = allGmCampaignsByPlayer.stream().map(c -> c.getMCharacters().contains(mChar)).collect(Collectors.toSet());
        boolean isGm = false;
        if (booleans.contains(true)) {
            isGm = true;
        }
        return isGm;
    }

}
