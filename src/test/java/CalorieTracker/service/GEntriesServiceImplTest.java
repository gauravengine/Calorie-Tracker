package CalorieTracker.service;


import CalorieTracker.controller.GetEntryForDateDTO;
import CalorieTracker.controller.GetNDaysCalsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class GEntriesServiceImplTest {
    @Autowired
    private EntriesServiceImpl entriesService;

    @Test
    public void temp(){
        GetNDaysCalsDTO getNDaysCalsDTO=GetNDaysCalsDTO
                .builder()
                .userId(2L)
                .startDate(LocalDate.of(2023,10,10))
                .endDate(LocalDate.of(2023,10,15))
                .build();

        System.out.println(entriesService.getEntriesForRange(getNDaysCalsDTO));
    }
}
