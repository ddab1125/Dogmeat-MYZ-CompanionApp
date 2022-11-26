package pl.coderslab.dogmeat.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dogmeat.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
