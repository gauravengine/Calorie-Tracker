package CalorieTracker.repository;

import CalorieTracker.entity.Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntriesRepository extends JpaRepository<Entries,Long> {
    List<Entries> findByUserUserIdAndLocalDate(Long userId, LocalDate localDate);

    List<Entries> findByUserUserIdAndLocalDateBetween(Long userId, LocalDate startDate,LocalDate endDate);
}
