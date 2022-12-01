package pl.coderslab.dogmeat.character.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dogmeat.equipment.entity.Equipment;
import pl.coderslab.dogmeat.user.entity.User;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data
@RequiredArgsConstructor
@Transactional
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

    private int damageValue;
    private int fatigueValue;
    private int confusionValue;
    private int doubtValue;

    private int endureValue;
    private int forceValue;
    private int fightValue;
    private int sneakValue;
    private int moveValue;
    private int shootValue;
    private int scoutValue;
    private int comprehendValue;
    private int knowTheZoneValue;
    private int senseEmotionValue;
    private int manipulateValue;
    private int healValue;
    private int professionSkillValue;



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
    private User user;

    @OneToMany()
    @JoinColumn(name = "mchar_id")
    private List<Equipment> equipment = new ArrayList<>();
}
