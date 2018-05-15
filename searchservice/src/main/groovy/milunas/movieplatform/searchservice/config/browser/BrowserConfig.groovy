package milunas.movieplatform.searchservice.config.browser

import geb.Browser
import milunas.movieplatform.searchservice.config.driver.DriverConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BrowserConfig {

    @Autowired
    DriverConfig driverConfig

    @Bean
    Browser openBrowser(){
        def browser = new Browser()
        browser.driver = driverConfig.buildDriver()
        return browser
    }

}
