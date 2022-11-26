package pl.coderslab.dogmeat.character.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.dogmeat.character.SimpleMCharacterDto;
import pl.coderslab.dogmeat.character.entity.MCharacter;

@Mapper
public interface MCharacterMapper {

    MCharacterMapper INSTANCE = Mappers.getMapper(MCharacterMapper.class);

    SimpleMCharacterDto mCharToMCharDto(MCharacter mCharacter);

}
