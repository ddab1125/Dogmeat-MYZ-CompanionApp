package pl.coderslab.dogmeat.campaign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.campaign.service.CampaignService;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.user.Dto.UserCampaignDto;
import pl.coderslab.dogmeat.user.entity.User;
import pl.coderslab.dogmeat.user.mapper.UserMapper;
import pl.coderslab.dogmeat.user.service.CurrentUser;
import pl.coderslab.dogmeat.user.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/campaign/new")
public class CampaignFormController {

    private final UserService userService;
    private final CampaignService campaignService;

    private final CharacterService characterService;

    @ModelAttribute("playersList")
    public List<UserCampaignDto> getAllPlayers() {
        return userService.findAll()
                .stream()
                .map(UserMapper.INSTANCE::userToUserCampaignDto)
                .toList();
    }

    @RequestMapping("")
    public String newCampaign() {

        return "fragments/newCampaign/step1";
    }

    @PostMapping("/step2")
    public String newCampaignStep2(@RequestParam String campaignName, Model model) {
        model.addAttribute("campaignName", campaignName);

        return "fragments/newCampaign/step2";
    }

    @PostMapping("/step3")
    public String newCampaignStep3(@RequestParam String campaignName,
                                   @RequestParam HashSet<Long> players,
                                   Model model) {
        model.addAttribute("campaignName", campaignName);
        model.addAttribute("players", players);
        List<List<MCharacter>> mCharactersByUser = players.stream().map(p -> characterService.findMCharacterByUserId(p)).toList();
        model.addAttribute("mCharacters", mCharactersByUser);


        return "fragments/newCampaign/step3";
    }

    @PostMapping("/finish")
    public String saveNewCampaign(@RequestParam String campaignName,
                                  @RequestParam HashSet<Long> players,
                                  @RequestParam List<Long> characters,
                                  @AuthenticationPrincipal CurrentUser currentUser) {
       Campaign campaign = new Campaign();
       campaign.setCampaignName(campaignName);
       campaign.setPlayers(players.stream().map(p -> userService.findUserById(p)).collect(Collectors.toList()));
       campaign.setMCharacters(characters.stream().map(c -> characterService.findMCharacterById(c)).collect(Collectors.toSet()));
       campaign.setGameMaster(currentUser.getUser());

       campaignService.saveCampaign(campaign);
        return "user/campaignlist";
    }


    @PostMapping("/new/finduser")
    private String findUser(@RequestParam("username") String username,
                            @ModelAttribute("campaign") Campaign campaign,
                            Model model) {
        List<User> userStartsWith = userService.findUserStartsWith(username);
        model.addAttribute("playersList", userStartsWith);
        return "fragments/newcampaignform";
    }
}
