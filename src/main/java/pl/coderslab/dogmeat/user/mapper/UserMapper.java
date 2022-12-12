package pl.coderslab.dogmeat.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.dogmeat.user.Dto.UserCampaignDto;
import pl.coderslab.dogmeat.user.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserCampaignDto userToUserCampaignDto(User user);
}
