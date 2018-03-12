package milunas.movieplatform.adviceservice.resource;

import milunas.movieplatform.adviceservice.model.Movie;
import milunas.movieplatform.adviceservice.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieResource {

    private final static String DB_SERVICE_URL = "";

    @Autowired
    RestTemplate restTemplate;

    public Movie[] getUserFavouriteMovies(Long userId){
        return restTemplate.getForObject(DB_SERVICE_URL, Movie[].class);
    }


    public Movie[] getMoviesByType(Type movieType){
        return restTemplate.getForObject(DB_SERVICE_URL, Movie[].class);
    }


}
