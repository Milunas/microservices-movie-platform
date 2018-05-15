package milunas.movieplatform.searchservice.model

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.TupleConstructor

@TupleConstructor
class Cinema {
    String name
    @JsonIgnore
    String baseUrl
    @JsonIgnore
    List<CinemaBranch> branches
    @JsonIgnore
    String showtimeSelector
    @JsonIgnore
    String movieTitleSelector
}