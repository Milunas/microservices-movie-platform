package milunas.movieplatform.searchservice.scrape

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ScrapRunner implements CommandLineRunner{

    private final static Integer DAY = 86400000

    @Autowired
    CinemaScraper scraper

    @Override
    void run(String... args) throws Exception {
        while (true) {
            scraper.scrape()
            Thread.sleep(DAY)
        }
    }
}
