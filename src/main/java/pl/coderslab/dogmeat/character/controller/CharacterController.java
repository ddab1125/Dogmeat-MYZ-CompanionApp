package pl.coderslab.dogmeat.character.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.character.service.CharacterService;

@Controller
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    private final CharacterRepository characterRepository;

    @RequestMapping("/char/random")

    public String generateCharacter(Model model) {
        MCharacter mCharacter = characterService.generateCharacter();
        model.addAttribute("mChar", mCharacter);
        return ("randomcharacter");
    }
}
