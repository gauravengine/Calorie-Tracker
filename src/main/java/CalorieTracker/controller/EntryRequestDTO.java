package CalorieTracker.controller;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EntryRequestDTO {
    private String foodName;
    private Long calories;
    private LocalDate localDate;
    private LocalTime localTime;
    private Long foodTypeId;
    private Long userId;
}
