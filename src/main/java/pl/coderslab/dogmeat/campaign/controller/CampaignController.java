package pl.coderslab.dogmeat.campaign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.campaign.service.CampaignService;
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

    @ModelAttribute("gmCampaignList")
    public List<Campaign> getGmCampaignList(@AuthenticationPrincipal CurrentUser currentUser) {
        return campaignService.findAllGmCampaignsByPlayer(currentUser.getUser().getId());
    }


    @RequestMapping()
    public String campaignList() {
        return "user/campaignlist";
    }


    @PostMapping("/delete")
    public String deleteCampaign(@RequestParam("campaignId") Long id) {
        campaignService.deleteCampaign(campaignService.findCampaignById(id));
        return "redirect:/user/campaign/";
    }

    @PostMapping("/details")
    public String campaignDetails(@RequestParam("campaignId") Long id,
                                  Model model) {
        model.addAttribute("campaign", campaignService.findCampaignById(id));
        model.addAttribute("campaignCharacterList", campaignService.getCampaignCharacterList(id));

        return "user/campaigndetails";
    }


}
