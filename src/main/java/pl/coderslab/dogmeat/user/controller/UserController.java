package pl.coderslab.dogmeat.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dogmeat.character.dto.SimpleMCharacterDto;
import pl.coderslab.dogmeat.character.mapper.MCharacterMapper;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.role.entity.Role;
import pl.coderslab.dogmeat.role.service.RoleService;
import pl.coderslab.dogmeat.user.entity.User;
import pl.coderslab.dogmeat.user.service.CurrentUser;
import pl.coderslab.dogmeat.user.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CharacterService characterService;
    private final UserService userService;
    private final RoleService roleService;


    @ModelAttribute("mCharacters")
    public List<SimpleMCharacterDto> getSheetList(@AuthenticationPrincipal CurrentUser currentUser) {
        return characterService.findMCharacterByUserId(currentUser.getUser().getId()).stream()
                .map(MCharacterMapper.INSTANCE::mCharToMCharDto)
                .toList();
    }


    @RequestMapping("/dashboard")
    public String userDashboard(@AuthenticationPrincipal CurrentUser currentUser,
                                Model model) {
        if (!currentUser.equals(null)) {
            Set<Role> roles = currentUser.getUser().getRoles();
            model.addAttribute("userRoles", roles);
        }

        return ("/user/dashboard");
    }

    @RequestMapping("/list")
    public String userCharacterList(Model model) {
        model.getAttribute("mCharacters");
        return ("user/character/characterslist");
    }

    @PostMapping("/role")
    public String saveRoles(@AuthenticationPrincipal CurrentUser currentUser,
                            @RequestParam List<String> roles) {
        User user = currentUser.getUser();
        int adminFlag;
        if (currentUser.getUser().getRoles().contains(roleService.findRoleByName("admin"))) {
            adminFlag = 1;
        } else {
            adminFlag = 0;
        }
        user.setRoles(new HashSet<>());
        roles.forEach(r -> user.getRoles().add(roleService.findRoleByName(r)));
        if (adminFlag == 1) {
        }
        user.getRoles().add(roleService.findRoleByName("admin"));
        userService.save(user);


        return ("/user/dashboard");
    }

}
