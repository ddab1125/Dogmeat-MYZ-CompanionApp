package pl.coderslab.dogmeat.equipment.entity;


import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.coderslab.dogmeat.weapon.entity.Weapon;

import javax.persistence.*;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private int itemQuantity;
    private double itemWeight;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;


}
