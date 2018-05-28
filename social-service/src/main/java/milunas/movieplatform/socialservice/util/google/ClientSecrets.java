package milunas.movieplatform.socialservice.util.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClientSecrets {

    @Value("${google.client.client-id}")
    private String clientId;
    @Value("${google.client.client-secret}")
    private String clientSecret;

    @Bean
    public GoogleClientSecrets secrets(){
        return new GoogleClientSecrets()
                .setWeb(details());
    }

    private GoogleClientSecrets.Details details() {
        GoogleClientSecrets.Details details = new GoogleClientSecrets.Details();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        return details;
    }
}
