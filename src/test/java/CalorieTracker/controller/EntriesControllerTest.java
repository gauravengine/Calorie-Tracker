package CalorieTracker.controller;

import CalorieTracker.errors.CustomException;
import CalorieTracker.service.EntriesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntriesControllerTest {

    @InjectMocks
    private EntriesController entriesController;

    @Mock
    private EntriesService entriesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateEntry_Error() {
        doThrow(new RuntimeException("Test Exception")).when(entriesService).createEntry(null);

        assertThrows(CustomException.class, () -> {
            entriesController.createEntry(null);
        });
    }

    // Add similar tests for other methods in EntriesController
}
