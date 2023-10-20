package CalorieTracker.service;

import CalorieTracker.errors.CustomException;
import CalorieTracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser_Error() {
        doThrow(new RuntimeException("Test Exception")).when(userRepository).save(null);

        assertThrows(CustomException.class, () -> {
            userService.addUser(null);
        });
    }

    // Add similar tests for other methods in UserService
}
