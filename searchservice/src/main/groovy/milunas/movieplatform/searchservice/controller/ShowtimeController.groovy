package milunas.movieplatform.searchservice.controller

import milunas.movieplatform.searchservice.service.ShowtimeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class ShowtimeController {

    @Autowired
    ShowtimeService service

    @GetMapping
    def findShowtimes(@RequestParam("by") String by, @RequestParam("param") String param){
        switch (by){
            case "cinema" : return service.findByCinema(param) ; break
            case "movie"  : return service.findByMovieTitle(param) ; break
            default       : throw new RuntimeException("There's no such searching parameter")
        }
    }

}
