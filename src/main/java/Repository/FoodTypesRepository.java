package Repository;

import entity.FoodTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypesRepository extends JpaRepository<FoodTypes,Long> {
}
