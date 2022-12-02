package pl.coderslab.dogmeat.character.util;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class CharacterMutations {

    private static final List<String> MUTATIONS =
            List.of("manbeast",
                    "fourhanded",
                    "echolocation",
                    "insectoid",
                    "reptilian",
                    "humanplant",
                    "humanmagnet",
                    "reflex",
                    "firebreath",
                    "insectwings",
                    "parasite",
                    "pathokinesis",
                    "pirokinesis",
                    "roteater",
                    "mindterror",
                    "sprinter",
                    "luminesence",
                    "telepathy",
                    "tracker",
                    "corpseeater",
                    "amphibian",
                    "pupeteer",
                    "spores",
                    "froglegs",
                    "acidspit");

    public static String getRandomMutation() {
        Random random = new Random();

        return MUTATIONS.get(random.nextInt(MUTATIONS.size()));
    }
}
