package pl.coderslab.dogmeat.character;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class CharacterDescriptions {

    private static final List<String> ENFORCER_FACE =
            List.of("Złamany nos",
                    "Martwe spojrzenie",
                    "Pobliźniona głowa",
                    "Ukryta pod kapturem",
                    "Blada jak ściana",
                    "Zniekształcona"

            );
    private static final List<String> ENFORCER_BODY =
            List.of("pokryte bliznami",
                    "muskularne",
                    "krępe",
                    "ulane",
                    "żylaste",
                    "zdeformowane");

    private static final List<String> ENFORCER_CLOTHES =
            List.of("znoszony skórzany płaszcz",
                    "brudny kombinezon",
                    "połatany garnitur",
                    "podkoszulek i podarte spodnie",
                    "skórzaną kamizelkę ze wstawkami z pociętych opon");

    public static String getRandomDescription() {
        Random random = new Random();

        return ENFORCER_FACE.get(random.nextInt(ENFORCER_FACE.size())) + ", " +
                ENFORCER_BODY.get(random.nextInt(ENFORCER_BODY.size())) + " ciało. Ubrany w " +
                ENFORCER_CLOTHES.get(random.nextInt(ENFORCER_CLOTHES.size()));
    }
}
