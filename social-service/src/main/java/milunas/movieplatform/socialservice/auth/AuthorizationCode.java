package milunas.movieplatform.socialservice.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.calendar.CalendarScopes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthorizationCode {

    @Autowired
    NetHttpTransport transport;
    @Autowired
    JsonFactory jsonFactory;
    @Autowired
    GoogleClientSecrets secrets;

    @Bean
    public GoogleAuthorizationCodeFlow authorization(){
        return new GoogleAuthorizationCodeFlow
                .Builder(transport, jsonFactory, secrets, Collections.singleton(CalendarScopes.CALENDAR))
                .build();
    }
}
