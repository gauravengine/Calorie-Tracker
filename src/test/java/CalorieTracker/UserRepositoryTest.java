package CalorieTracker;

import entity.User;
import Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void userEntryTest(){
        String url="hello";
        User user= User
                .builder()
                .userName("Gaurav")
                .dateOfBirth(LocalDate.of(2001,2,8))
                .height(81.9)
                .profileImgUrl(88.8)
                .weight(8.9)
                .build();
    }
}
