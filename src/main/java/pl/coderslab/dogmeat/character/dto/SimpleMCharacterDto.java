package pl.coderslab.dogmeat.character.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SimpleMCharacterDto {

    private Long id;
    private String name;
    private String profession;


}
