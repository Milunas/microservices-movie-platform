package milunas.movieplatform.searchservice.scrape

import geb.Browser
import milunas.movieplatform.searchservice.config.browser.BrowserConfig
import milunas.movieplatform.searchservice.model.CinemaBranch
import milunas.movieplatform.searchservice.model.Movie
import milunas.movieplatform.searchservice.model.Showtime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CinemaBranchScrape {

    @Autowired
    BrowserConfig browserConfig

    def scrapeCinema(CinemaBranch cinemaBranch){
        def movies = new ArrayList<Showtime>()
        Browser browser = browserConfig.openBrowser()
        Browser.drive (browser){
            go buildUrl(cinemaBranch)
            $(cinemaBranch.cinemaBrand.showtimeSelector)
            .children()
            .collect()
            .each {
                element ->
                    def movieTitle = element.find(cinemaBranch.cinemaBrand.movieTitleSelector).text()
                    if(movieTitle?.trim()){
                        movies.add new Showtime(new Movie(movieTitle), cinemaBranch)
                    }
            }
        }
        return movies
    }

    private String buildUrl(CinemaBranch cinemaBranch){
        return cinemaBranch.cinemaBrand.baseUrl + cinemaBranch.url
    }
}
