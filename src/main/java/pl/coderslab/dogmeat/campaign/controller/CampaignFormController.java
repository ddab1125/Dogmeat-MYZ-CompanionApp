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
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.role.service.RoleService;
import pl.coderslab.dogmeat.user.Dto.UserCampaignDto;
import pl.coderslab.dogmeat.user.entity.User;
import pl.coderslab.dogmeat.user.mapper.UserMapper;
import pl.coderslab.dogmeat.user.service.CurrentUser;
import pl.coderslab.dogmeat.user.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/campaign/new")
public class CampaignFormController {

    private final UserService userService;
    private final CampaignService campaignService;

    private final CharacterService characterService;
    private final RoleService roleService;

    private HashSet<Long> currentPlayers;

    @ModelAttribute("playersList")
    public List<UserCampaignDto> getAllPlayers() {
        return userService.findAllUsersByRole(roleService.findRoleByName("player"))
                .stream()
                .map(UserMapper.INSTANCE::userToUserCampaignDto)
                .toList();
    }

    @RequestMapping("")
    public String newCampaign() {
    currentPlayers = new HashSet<>();
        return "user/campaign/step1";
    }

    @PostMapping("/step2")
    public String newCampaignStep2(@RequestParam String campaignName,
                                   @RequestParam String campaignDescription,
                                   Model model) {

        model.addAttribute("campaignName", campaignName);
        model.addAttribute("campaignDescription", campaignDescription);

        return "user/campaign/step2";
    }

    @PostMapping("/step3")
    public String newCampaignStep3(@RequestParam String campaignName,
                                   @RequestParam String campaignDescription,
                                   @RequestParam HashSet<Long> players,
                                   Model model) {
        model.addAttribute("campaignName", campaignName);
        model.addAttribute("players", players);
        model.addAttribute("campaignDescription", campaignDescription);
        if (players.isEmpty()) {
            return "user/campaign/step2";
        }
        List<List<MCharacter>> mCharactersByUser = players.stream().map(p -> characterService.findMCharacterByUserId(p)).toList();
        model.addAttribute("mCharacters", mCharactersByUser);


        return "user/campaign/step3";
    }

    @PostMapping("/finish")
    public String saveNewCampaign(@RequestParam String campaignName,
                                  @RequestParam String campaignDescription,
                                  @RequestParam HashSet<Long> players,
                                  @RequestParam List<Long> characters,
                                  @AuthenticationPrincipal CurrentUser currentUser) {
        Campaign campaign = new Campaign();
        campaign.setCampaignName(campaignName);
        campaign.setPlayers(players.stream().map(p -> userService.findUserById(p)).collect(Collectors.toList()));
        campaign.setMCharacters(characters.stream().map(c -> characterService.findMCharacterById(c)).collect(Collectors.toSet()));
        campaign.setGameMaster(currentUser.getUser());
        campaign.setCampaignDescription(campaignDescription);

        campaignService.saveCampaign(campaign);
        return "redirect:/user/campaign";
    }


    @PostMapping("/finduser")
    private String findUser(@RequestParam("username") String username,
                            @RequestParam("campaignName") String campaignName,
                            @RequestParam("campaignDescription") String campaignDescription,
                            Model model) {
        List<User> userStartsWith = userService.findUserStartsWith(username);
        model.addAttribute("campaignName", campaignName);
        model.addAttribute("playersList", userStartsWith);
        model.addAttribute("campaignDescription", campaignDescription);
        model.addAttribute("currentPlayers", currentPlayers.stream().map(p -> userService.findUserById(p)).toList());
        return "user/campaign/step2";
    }


    @PostMapping("/adduser")
    private String addUser(@RequestParam String campaignName,
                           @RequestParam String campaignDescription,
                           @RequestParam HashSet<Long> players,
                           Model model) {

        currentPlayers.addAll(players);
        model.addAttribute("campaignDescription", campaignDescription);
        model.addAttribute("campaignName", campaignName);
        model.addAttribute("players", currentPlayers);
        model.addAttribute("currentPlayers", currentPlayers.stream().map(p -> userService.findUserById(p)).toList());

        return "user/campaign/step2";
    }

}
