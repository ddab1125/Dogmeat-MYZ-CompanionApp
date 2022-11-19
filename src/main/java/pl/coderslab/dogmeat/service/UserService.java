package pl.coderslab.dogmeat.service;

import pl.coderslab.dogmeat.Dto.UserDto;
import pl.coderslab.dogmeat.entity.User;

public interface UserService {

    User findByUsername(String name);

    void saveUser(UserDto userDto);
}
