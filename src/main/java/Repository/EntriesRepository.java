package Repository;

import entity.Entries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntriesRepository extends JpaRepository<Entries,Long> {
}
