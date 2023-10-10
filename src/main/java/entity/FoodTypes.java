package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodTypeId;


    private String foodTypeName;

}
