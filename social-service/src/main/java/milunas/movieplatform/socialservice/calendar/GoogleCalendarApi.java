package milunas.movieplatform.socialservice.calendar;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.calendar.Calendar;
import milunas.movieplatform.socialservice.auth.AuthorizationCredential;
import milunas.movieplatform.socialservice.auth.AuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleCalendarApi {

    @Autowired
    NetHttpTransport transport;
    @Autowired
    JsonFactory jsonFactory;
    @Autowired
    AuthorizationCredential credentialService;
    @Autowired
    AuthorizationToken authorizationToken;

    public Calendar calendar(String code) throws IOException {
        return new Calendar
                .Builder(transport, jsonFactory, credentials(code))
                .build();
    }

    private Credential credentials(String code) throws IOException {
        return credentialService.credential(token(code));
    }

    private TokenResponse token(String code) throws IOException {
        return authorizationToken.getToken(code);
    }

}
