package milunas.movieplatform.socialservice.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/google")
public class AuthorizationController {

    @Autowired
    private AuthorizationService service;

    @GetMapping
    public String getAuthUrl(){
        return service.authorize();
    }

    @GetMapping(params = "code")
    public String authCallback(@RequestParam(value = "code") String code){
        return code;
    }

}
