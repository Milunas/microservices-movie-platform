package milunas.movieplatform.adviceservice.analyze;

import milunas.movieplatform.adviceservice.model.Movie;
import milunas.movieplatform.adviceservice.model.Type;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFavouriteTypeAnalyze {

    public Type findMostWatchedType(List<Movie> userFavouriteMovies){

        Map<Type, Integer> countedTypes = countHowManyTimesTypeAppears(userFavouriteMovies);

        return countedTypes
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .findFirst()
                .get()
                .getKey();
    }

    private Map<Type, Integer> countHowManyTimesTypeAppears(List<Movie> userFavouriteMovies){
        Map<Type, Integer> countedTypes = new HashMap();
        for (Movie favMovie: userFavouriteMovies) {
            Type movieType = favMovie.getType();
            if(countedTypes.containsKey(movieType)){
                Integer counter = countedTypes.get(movieType);
                counter++;
                countedTypes.replace(movieType, counter);
            }
            else {
                countedTypes.put(movieType, 0);
            }
        }
        return countedTypes;
    }
}
