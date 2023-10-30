package CalorieTracker.controller;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GetEntryForDateDTO {
    private Long userId;
    private LocalDate localDate;
}
