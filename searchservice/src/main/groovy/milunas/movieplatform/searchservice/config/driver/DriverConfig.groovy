package milunas.movieplatform.searchservice.config.driver

import org.apache.catalina.core.ApplicationContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService
import org.openqa.selenium.remote.DesiredCapabilities
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DriverConfig {


    private final static PHANTOMJS = PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY
    private final static PHANTOMJS_PATH = ApplicationContext.getResource("phantomjs.exe")
    private final static String[] WEB_CAPABILITIES = ["--ignore-ssl-errors=true","--ssl-protocol=TLSv1"]

    @Bean
    WebDriver buildDriver(){
        WebDriver driver = new PhantomJSDriver(buildCapabilities())
        return driver
    }

    @Bean
    DesiredCapabilities buildCapabilities(){
        DesiredCapabilities caps = new DesiredCapabilities()
        caps.setJavascriptEnabled(true)
        caps.setCapability(PHANTOMJS, PHANTOMJS_PATH)
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, WEB_CAPABILITIES)
        return caps
    }

}
