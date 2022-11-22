package pl.coderslab.dogmeat.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @RequestMapping("/")
    public String homePage() {
        return "home";
    }

}
