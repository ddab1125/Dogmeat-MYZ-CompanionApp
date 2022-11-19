package pl.coderslab.dogmeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dogmeat.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
