package pl.coderslab.dogmeat.weapon.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.dogmeat.equipment.entity.Equipment;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String weaponName;
    private int weaponBonus;
    private int weaponDamage;
    private String weaponRange;
    private String weaponSpecial;

    private double weaponWeight;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Equipment item;

}
