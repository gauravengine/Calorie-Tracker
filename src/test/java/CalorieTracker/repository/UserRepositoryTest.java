package CalorieTracker.repository;

import CalorieTracker.entity.FoodType;
import CalorieTracker.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void saveUserTest(){
        String url="hello";
        User user= User
                .builder()
                .userName("Gaurav")
                .dateOfBirth(LocalDate.of(2001,2,8))
                .height(81.9)
                .profileImgUrl(url)
                .weight(8.9)
                .build();
        userRepository.save(user);
    }



}
