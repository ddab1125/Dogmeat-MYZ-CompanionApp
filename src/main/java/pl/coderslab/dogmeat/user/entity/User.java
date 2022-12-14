package pl.coderslab.dogmeat.user.entity;

import lombok.Data;
import pl.coderslab.dogmeat.campaign.entity.Campaign;
import pl.coderslab.dogmeat.role.entity.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private int enabled;


    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(mappedBy = "players")
    private List<Campaign> campaigns = new ArrayList<>();


}
