package CalorieTracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateSumCalorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dateSumCalorieId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate localDate;

    private Long calorieSum;
}
