package CalorieTracker.repository;

import CalorieTracker.entity.Entries;
import CalorieTracker.entity.FoodType;
import CalorieTracker.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
public class EntriesRepositoryTest {
    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntriesRepository entriesRepository;
    @Test
    public void saveEntry(){
        Long userId=1L;
        Long foodTypeId=1L;
        User user = userRepository.findByUserId(userId);
        FoodType foodType=foodTypeRepository.findByFoodTypeId(foodTypeId);

        Entries entries=Entries
                .builder()
                .calories(500L)
                .localDate(LocalDate.of(1001,2,3))
                .localTime(LocalTime.of(12,30,43))
                .foodName("Biryani")
                .user(user)
                .foodType(foodType)
                .build();

        entriesRepository.save(entries);
    }

}
