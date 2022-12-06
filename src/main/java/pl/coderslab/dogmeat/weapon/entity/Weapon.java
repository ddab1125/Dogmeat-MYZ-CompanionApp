package pl.coderslab.dogmeat.weapon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
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

}
