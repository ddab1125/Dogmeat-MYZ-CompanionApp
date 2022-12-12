package pl.coderslab.dogmeat.campaign.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.campaign.repository.CampaignRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final CampaignRepository campaignRepository;

    public List<Campaign> findAllCampaignsByPlayer(Long id){
        return campaignRepository.findAllCampaignsByPlayersId(id);
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
}
