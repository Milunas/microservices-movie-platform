package milunas.movieplatform.socialservice.util.google;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JsonDefaultInstance {

    @Bean
    public JsonFactory jsonFactory(){
        return JacksonFactory.getDefaultInstance();
    }

}
