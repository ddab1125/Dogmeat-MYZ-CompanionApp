package pl.coderslab.dogmeat.equipment.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;


@Entity
@Data
@RequiredArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;


}
