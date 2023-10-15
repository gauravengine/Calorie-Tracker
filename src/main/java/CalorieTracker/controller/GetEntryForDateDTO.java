package CalorieTracker.controller;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetEntryForDateDTO {
    private Long userId;
    private LocalDate localDate;
}
