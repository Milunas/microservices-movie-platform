package milunas.movieplatform.adviceservice.controller;

import milunas.movieplatform.adviceservice.analyze.Advicer;
import milunas.movieplatform.adviceservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    Advicer advicer;

    @GetMapping("/{userId}")
    public List<Movie> recommendMoviesForUser(@PathVariable String userId){
        return advicer.recommend(userId);
    }

}
