package pl.coderslab.dogmeat.character.util;


import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class CharacterNames {


    private static final List<String> CHARACTER_NAMES =
            List.of("Abar",
                    "Alix",
                    "Delta",
                    "Iridia",
                    "Erister",
                    "Lard",
                    "Mubba",
                    "Mohan",
                    "Rutger",
                    "Grits"
    );

    private static final List<String> ENFORCER_NAMES =
            List.of("Hugust",
                    "Lenny",
                    "Pontis",
                    "Mubba"
            );


     public static String getRandomName() {
        Random random = new Random();
        return CHARACTER_NAMES.get(random.nextInt(CHARACTER_NAMES.size()));
    }



}
