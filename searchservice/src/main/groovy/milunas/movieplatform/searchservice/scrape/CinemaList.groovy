package milunas.movieplatform.searchservice.scrape

import milunas.movieplatform.searchservice.model.Cinema
import milunas.movieplatform.searchservice.model.CinemaBranch
import milunas.movieplatform.searchservice.service.CinemaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
class CinemaList {

    @Autowired
    CinemaService service

    static List<Cinema> cinemas(){
        def cinemas = new ArrayList<Cinema>()
        def multikino = new Cinema()
        multikino.setName("Multikino")
        multikino.setBaseUrl("https://multikino.pl/repertuar")
        multikino.setShowtimeSelector("#filmlist__data")
        multikino.setMovieTitleSelector("#filmlist__data > div > div > div.filmlist__info.filmlist__info--inverted > div.filmlist__info-txt > a > span")
        def branches = new ArrayList<CinemaBranch>()
        branches.add new CinemaBranch("Zlote Tarasy", multikino, "/warszawa-zlote-tarasy")
        multikino.setBranches(branches)
        cinemas.add multikino
        return cinemas
    }

    @PostConstruct
    def saveCinemas(){
        service.saveMany(cinemas())
    }
}
