package milunas.movieplatform.dbservice.resource;

import milunas.movieplatform.dbservice.model.Movie;
import milunas.movieplatform.dbservice.model.Type;
import milunas.movieplatform.dbservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/db/movie")
public class MovieResource {

    @Autowired
    private MovieRepository repository;

    @GetMapping("{/byTitle/movieTitle}")
    public Movie getMovieByTitle(@PathVariable String movieTitle){
        return repository.findMovieByMovieTitle(movieTitle);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return repository.findAll();
    }

    @GetMapping("/byType/{movieType}")
    public List<Movie> getMoviesByType(@PathVariable Type movieType){
        return repository.findMovieByType(movieType);
    }

    @PostMapping
    public String addNewMovie(@RequestBody Movie movie){
        Movie entityMovie = new Movie();
        entityMovie.setTitle(movie.getTitle());
        repository.save(movie);
        return movie.getTitle();
    }

}
