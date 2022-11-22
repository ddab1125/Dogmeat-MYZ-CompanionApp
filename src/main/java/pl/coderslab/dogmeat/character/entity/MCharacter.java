package pl.coderslab.dogmeat.character.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.coderslab.dogmeat.user.entity.User;


import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class MCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String profession;
    private String description;
    private int strengthValue;
    private int agilityValue;
    private int witsValue;
    private int empathyValue;

    public MCharacter(int strengthValue, int agilityValue, int witsValue, int empathyValue) {
        this.strengthValue = strengthValue;
        this.agilityValue = agilityValue;
        this.witsValue = witsValue;
        this.empathyValue = empathyValue;
    }

    @ManyToOne
    @JoinColumn()
    private User user;
}
