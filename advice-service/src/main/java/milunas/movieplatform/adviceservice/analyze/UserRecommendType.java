package milunas.movieplatform.adviceservice.analyze;

import milunas.movieplatform.adviceservice.model.Movie;
import milunas.movieplatform.adviceservice.model.Type;
import milunas.movieplatform.adviceservice.resource.MovieResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRecommendType implements Advicer {

    @Autowired
    private UserFavouriteTypeAnalyze analyzer;
    @Autowired
    private MovieResource resource;

    public List<Movie> recommend(String userId){
        List recommendedMovies = new ArrayList();
        Long id = new Long(userId);
        List<Movie> userFavouriteMovies = new ArrayList<>();
        userFavouriteMovies.addAll(Arrays.asList(resource.getUserFavouriteMovies(new Long(userId))));
        Type favType = analyzer.findMostWatchedType(userFavouriteMovies);
        for (Movie movie: resource.getMoviesByType(favType)) {
            if(!userFavouriteMovies.contains(movie))
                recommendedMovies.add(movie);
        }
        return recommendedMovies;
    }
}
