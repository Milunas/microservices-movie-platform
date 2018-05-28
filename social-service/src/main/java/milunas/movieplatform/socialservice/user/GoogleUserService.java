package milunas.movieplatform.socialservice.user;

import com.google.api.services.calendar.model.CalendarListEntry;
import milunas.movieplatform.socialservice.calendar.GoogleCalendarApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GoogleUserService {

    @Autowired
    private GoogleCalendarApi calendarApi;

    public List<CalendarListEntry> getCalendarItems(String code){
        try {
            return calendarApi
                    .calendar(code)
                    .calendarList()
                    .list()
                    .execute()
                    .getItems();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
