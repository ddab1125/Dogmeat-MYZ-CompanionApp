package pl.coderslab.dogmeat.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dogmeat.campaign.entity.Campaign;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

List<Campaign> findAllCampaignsByPlayersId(Long id);

Campaign findCampaignById(Long id);

List<Campaign> findAllCampaignsByGameMasterId(Long id);


}
