package CalorieTracker.repository;

import CalorieTracker.entity.DateSumCalorie;
import CalorieTracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface DateSumCalorieRepository extends JpaRepository<DateSumCalorie,Long> {
    public DateSumCalorie findByUserAndLocalDate(User user, LocalDate localDate) ;
}
