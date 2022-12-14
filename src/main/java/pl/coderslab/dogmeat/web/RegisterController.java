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
import pl.coderslab.dogmeat.web.email.EmailDetails;
import pl.coderslab.dogmeat.web.email.EmailService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final EmailService emailService;


    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "admin/registration";
    }


    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult result,
                                  EmailDetails details) {


        if (result.hasErrors()) {
            return "/admin/registration";
        }
        details.setRecipient(userDto.getEmail());
        details.setSubject("Rejestracja");
        details.setMsgBody("Dzieki za rejestracje w aplikacji DogMeat!");
        emailService.sendSimpleMail(details);
        userService.saveUser(userDto);

        return "/home";
    }
}
