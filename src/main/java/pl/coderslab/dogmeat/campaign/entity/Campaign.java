package pl.coderslab.dogmeat.campaign.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.coderslab.dogmeat.character.entity.MCharacter;
import pl.coderslab.dogmeat.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String campaignName;

    private String campaignDescription;

    @ManyToOne
    @JoinColumn(name = "gm_id")
    private User gameMaster;

    @ManyToMany
    @JoinTable(name = "campaign_player",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<User> players = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "campaign_mcharacters")
    private Set<MCharacter> mCharacters = new HashSet<>();
}
