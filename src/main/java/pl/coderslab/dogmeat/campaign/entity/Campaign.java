package pl.coderslab.dogmeat.campaign.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.coderslab.dogmeat.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String campaignName;

    @ManyToOne
    @JoinColumn(name = "gm_id")
    private User gameMaster;

    @ManyToMany
    @JoinTable(name = "campaign_player",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<User> players = new ArrayList<>();
}
