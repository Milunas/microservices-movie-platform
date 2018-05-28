package milunas.movieplatform.socialservice.auth;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthorizationToken {

    @Value("${google.client.redirectUri}")
    private String redirectURI;
    @Autowired
    private GoogleAuthorizationCodeFlow authorizationCode;

    public TokenResponse getToken(String code) throws IOException {
        return authorizationCode
                .newTokenRequest(code)
                .setRedirectUri(redirectURI)
                .execute();
    }
}
