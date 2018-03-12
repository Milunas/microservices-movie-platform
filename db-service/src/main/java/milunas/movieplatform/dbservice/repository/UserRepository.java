package milunas.movieplatform.dbservice.repository;

import milunas.movieplatform.dbservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
