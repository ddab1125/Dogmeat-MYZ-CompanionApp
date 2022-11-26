package pl.coderslab.dogmeat.web;




import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dogmeat.user.Dto.UserDto;
import pl.coderslab.dogmeat.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;


    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "admin/registration";
    }


    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult result) {


        if (result.hasErrors()) {
            return "/admin/registration";
        }
        userService.saveUser(userDto);
        return "/home";
    }
}
