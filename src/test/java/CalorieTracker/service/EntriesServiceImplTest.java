package CalorieTracker.service;

import CalorieTracker.controller.GetEntryForDateDTO;
import CalorieTracker.controller.GetNDaysCalsDTO;
import CalorieTracker.errors.CustomException;
import CalorieTracker.repository.EntriesRepository;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class EntriesServiceImplTest {


    @InjectMocks
    private EntriesServiceImpl entriesServiceImpl;

    @Mock
    private EntriesRepository entriesRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

    }
    @Test
    public void testCreateEntry_Error(){
        doThrow(new RuntimeException("Test Exception")).when(entriesRepository).save(null);
        assertThrows(CustomException.class, () -> {
            entriesServiceImpl.createEntry(null);
        });
    }
//    subsequent tests

    @Test
    public void temp(){
        GetNDaysCalsDTO getNDaysCalsDTO=GetNDaysCalsDTO
                .builder()
                .userId(1L)
                .startDate(LocalDate.of(2023,10,10))
                .endDate(LocalDate.of(2023,10,15))
                .build();

        GetEntryForDateDTO getEntryForDateDTO=GetEntryForDateDTO
                .builder()
                .userId(1L)
                .localDate(LocalDate.of(2023,10,13))
                .build();

        System.out.println(entriesServiceImpl.getEntriesForDate(getEntryForDateDTO));
    }
}
