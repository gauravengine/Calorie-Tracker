package CalorieTracker.controller;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GetNDaysCalsDTO {
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
}
