package pl.coderslab.dogmeat.character.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.character.repository.CharacterRepository;
import pl.coderslab.dogmeat.character.service.CharacterService;
import pl.coderslab.dogmeat.user.service.CurrentUser;

@Controller
@RequiredArgsConstructor
@SessionAttributes("mChar")

public class CharacterController {

    private final CharacterService characterService;
    private final CharacterRepository characterRepository;


    @GetMapping("char/random")
    public String randomMCharacter(Model model) {
        MCharacter mChar = characterService.generateCharacter();
        model.addAttribute("mChar", mChar);
        return ("randomcharacter");
    }

    @PostMapping("char/random")
    public String saveRandomMCharacter(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        MCharacter mChar = (MCharacter) model.getAttribute("mChar");
        mChar.setUser(currentUser.getUser());
        characterRepository.save(mChar);

        return ("randomcharacter");
    }


}
