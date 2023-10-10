package CalorieTracker.repository;

import CalorieTracker.entity.FoodType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FoodTypeRepositoryTest {
    @Autowired
    FoodTypeRepository foodTypeRepository;

    @Test
    public void saveFoodTypesTest(){
        FoodType foodType=FoodType
                .builder()
                .foodTypeName("Protein")
                .build();
        foodTypeRepository.save(foodType);
    }


}
