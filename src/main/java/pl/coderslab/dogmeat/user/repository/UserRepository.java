package pl.coderslab.dogmeat.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dogmeat.role.entity.Role;
import pl.coderslab.dogmeat.user.entity.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserById(Long id);

    User findUserByEmail(String email);

    List<User> findUsersByUsernameStartsWithIgnoreCase(String username);

    List<User> findUsersByRolesContaining(Role role);


}
