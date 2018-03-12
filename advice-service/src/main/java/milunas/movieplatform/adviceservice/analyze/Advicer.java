package milunas.movieplatform.adviceservice.analyze;

import milunas.movieplatform.adviceservice.model.Movie;

import java.util.List;

public interface Advicer {
    List<Movie> recommend(String userId);
}
