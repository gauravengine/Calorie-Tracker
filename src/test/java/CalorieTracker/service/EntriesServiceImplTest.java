package CalorieTracker.service;

import CalorieTracker.errors.CustomException;
import CalorieTracker.repository.EntriesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class EntriesServiceImplTest {


    @InjectMocks
    private EntriesService entriesService;

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
            entriesService.createEntry(null);
        });
    }
//    subsequent tests
}
