package milunas.movieplatform.socialservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/social/user")
public class GoogleUserController {

    @Autowired
    private GoogleUserService service;

    @GetMapping
    public String getAmountOfUserCalendars(@RequestParam String code){
        return service.getCalendarItems(code).size() + "";
    }

}
