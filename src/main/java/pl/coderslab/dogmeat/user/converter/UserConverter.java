package pl.coderslab.dogmeat.user.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.dogmeat.user.entity.User;
import pl.coderslab.dogmeat.user.service.UserService;

@Component
public class UserConverter implements Converter<String, User> {

    private UserService userService;


    @Override
    public User convert(String source) {
        return userService.findUserById(Long.valueOf(source));
    }
}
