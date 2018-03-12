package milunas.movieplatform.dbservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Showtime {

    @Id
    @GeneratedValue
    private long id;
}
