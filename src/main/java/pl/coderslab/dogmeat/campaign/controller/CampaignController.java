package pl.coderslab.dogmeat.campaign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.campaign.service.CampaignService;
import pl.coderslab.dogmeat.user.Dto.UserCampaignDto;
import pl.coderslab.dogmeat.user.mapper.UserMapper;
import pl.coderslab.dogmeat.user.service.CurrentUser;
import pl.coderslab.dogmeat.user.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/campaign")
public class CampaignController {

    private final CampaignService campaignService;
    private final UserService userService;

    @ModelAttribute("campaignList")
    public List<Campaign> getCampaignsList(@AuthenticationPrincipal CurrentUser currentUser) {
        return campaignService.findAllCampaignsByPlayer(currentUser.getUser().getId());
    }

    @ModelAttribute("playersList")
    public List<UserCampaignDto> getAllPlayers() {
        return userService.findAll()
                .stream()
                .map(UserMapper.INSTANCE::userToUserCampaignDto)
                .toList();
    }


    @RequestMapping()
    public String campaignList() {
        return "user/campaignlist";
    }

    @RequestMapping("/new")
    public String newCampaign(@ModelAttribute("campaign") Campaign campaign) {
        return "fragments/newcampaignform";
    }

    @PostMapping("/new")
    public String saveNewCampaign(@AuthenticationPrincipal CurrentUser currentUser,
                                  @ModelAttribute("campaign") Campaign campaign) {
        campaign.setGameMaster(currentUser.getUser());
        campaign.getPlayers().add(currentUser.getUser());
    campaignService.saveCampaign(campaign);
        return "user/campaignlist";
    }
}
