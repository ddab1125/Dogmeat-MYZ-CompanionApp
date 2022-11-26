package pl.coderslab.dogmeat.character.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.coderslab.dogmeat.user.entity.User;


import javax.persistence.*;
import java.util.Random;

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


    //TODO add implementations for main attritbute for a proffesion so it can reach value of 5
    public static int[] randomAttributes() {
        int[] stats = {0, 0, 0, 0};
        int pointsPool = 14;
        Random random = new Random();

        while (pointsPool > 0) {
            int distributedPoints = random.nextInt(3) + 2;
            if (distributedPoints > pointsPool) {
                distributedPoints = pointsPool;
            }
            int i = random.nextInt(stats.length);
            if (!(stats[i] + distributedPoints > 4)) {
                stats[i] += distributedPoints;
                pointsPool -= distributedPoints;
            }

        }

        for (int stat : stats) {
            if (stat < 2) {
               return randomAttributes();
            }

        }
        return stats;
    }

    @ManyToOne
    @JoinColumn()
    private User user;
}
