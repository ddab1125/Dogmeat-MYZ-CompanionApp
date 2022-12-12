package pl.coderslab.dogmeat.campaign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.campaign.repository.CampaignRepository;
import pl.coderslab.dogmeat.character.entity.MCharacter;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public List<Campaign> findAllCampaignsByPlayer(Long id){
        return campaignRepository.findAllCampaignsByPlayersId(id);
    }
    public List<Campaign> findAllGmCampaignsByPlayer(Long id){
        return campaignRepository.findAllCampaignsByGameMasterId(id);
    }

    public void saveCampaign(Campaign campaign){
        campaignRepository.save(campaign);
    }

    public Campaign findCampaignById(Long id){
        return campaignRepository.findCampaignById(id);
    }

    public void deleteCampaign(Campaign campaign) {
        campaignRepository.delete(campaign);
    }

    public Set<MCharacter> getCampaignCharacterList(Long campaignId){
        return campaignRepository.findCampaignById(campaignId).getMCharacters();
    }

}
