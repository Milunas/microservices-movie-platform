package milunas.movieplatform.socialservice.auth;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthorizationCredential {

    @Autowired
    private GoogleAuthorizationCodeFlow authorizationCode;

    public Credential credential(TokenResponse response) throws IOException {
        return authorizationCode.createAndStoreCredential(response, "userID");
    }

}
