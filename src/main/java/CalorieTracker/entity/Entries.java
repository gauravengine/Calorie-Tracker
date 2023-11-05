package CalorieTracker.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Entries")
public class Entries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;
    @NotBlank(message = "food Name has to be a String and can't be null or empty")
    private String foodName;

    @Positive(message = "calories cannot be negative")
    private Long calories;

    @PastOrPresent(message = "date has to be past or present")
    private LocalDate localDate;


    private LocalTime localTime;

    @ManyToOne
    @JoinColumn(name = "food_type_id")
    FoodType foodType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
