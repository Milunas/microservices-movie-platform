package milunas.movieplatform.searchservice.scrape

import geb.Browser
import milunas.movieplatform.searchservice.model.CinemaBranch
import milunas.movieplatform.searchservice.model.Movie
import milunas.movieplatform.searchservice.model.Showtime
import milunas.movieplatform.searchservice.service.ShowtimeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CinemaScraper{

    @Autowired
    ShowtimeService service

    @Autowired
    CinemaBranchScrape branchScrape

    def scrape(){
        CinemaList.cinemas().each {
            cinema -> cinema.branches.each {
                cinemaBranch -> saveAll(branchScrape.scrapeCinema(cinemaBranch))
            }
        }
    }

    private def saveAll(List<Showtime> showtimes){
        service.saveMany(showtimes)
    }

}
