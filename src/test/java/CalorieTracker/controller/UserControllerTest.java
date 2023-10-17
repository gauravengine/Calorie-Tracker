package CalorieTracker.controller;

import CalorieTracker.errors.CustomException;
import CalorieTracker.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddUser_Error() {
        doThrow(new RuntimeException("Test Exception")).when(userService).addUser(null);

        assertThrows(CustomException.class, () -> {
            userController.addUser(null);
        });
    }

    // Add similar tests for other methods in UserController
}
