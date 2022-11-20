package pl.coderslab.dogmeat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import pl.coderslab.dogmeat.Dto.UserDto;
import pl.coderslab.dogmeat.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/user/register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "admin/registration";
    }


    @PostMapping("/user/register")
    public String registerNewUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            return "/admin/registration";
        }
    userService.saveUser(userDto);
        return "/home";
    }
}
