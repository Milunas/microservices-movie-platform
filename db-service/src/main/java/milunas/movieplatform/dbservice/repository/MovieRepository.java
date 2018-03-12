package milunas.movieplatform.dbservice.repository;

import milunas.movieplatform.dbservice.model.Movie;
import milunas.movieplatform.dbservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findMovieByMovieTitle(String movieTitle);
    List<Movie> findMovieByType(Type type);
}
