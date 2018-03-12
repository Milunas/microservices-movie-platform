package milunas.movieplatform.dbservice.repository;

import milunas.movieplatform.dbservice.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
}
