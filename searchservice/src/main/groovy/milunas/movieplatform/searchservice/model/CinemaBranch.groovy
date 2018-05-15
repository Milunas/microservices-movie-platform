package milunas.movieplatform.searchservice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.TupleConstructor

@TupleConstructor
class CinemaBranch {
    String name
    Cinema cinemaBrand
    @JsonIgnore
    String url
}
