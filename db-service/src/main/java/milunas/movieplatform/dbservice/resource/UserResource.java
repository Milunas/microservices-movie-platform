package milunas.movieplatform.dbservice.resource;

import milunas.movieplatform.dbservice.model.Movie;
import milunas.movieplatform.dbservice.model.User;
import milunas.movieplatform.dbservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/db/user")
public class UserResource {

    @Autowired
    UserRepository repository;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId){
        return repository
                .findById(new Long(userId))
                .get();
    }

    @GetMapping("/{userId}/fav")
    public List<Movie> getUserFavMovies(@PathVariable String userId){
        return repository
                .findById(new Long(userId))
                .get()
                .getFavouriteMovies();
    }

}
