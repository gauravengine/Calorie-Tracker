package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Entries")
public class Entries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;

    private String foodName;


    private Long calories;

    private LocalDate localDate;


    private LocalTime localTime;

//    @OneToOne
//    @JoinColumn(name = "food_type_id")
//    FoodTypes foodTypes;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    User user;
}
