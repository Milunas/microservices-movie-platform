package milunas.movieplatform.socialservice.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class AuthorizationService {

    @Value("${google.client.redirectUri}")
    private String redirectURI;

    @Autowired
    private GoogleAuthorizationCodeFlow authorizationCode;

    String authorize(){
        return authorizationCode
                .newAuthorizationUrl()
                .setRedirectUri(redirectURI)
                .build();
        }
}

