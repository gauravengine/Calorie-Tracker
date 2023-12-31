package CalorieTracker.repository;

import CalorieTracker.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType,Long> {
    public FoodType findByFoodTypeId(Long id);
}
