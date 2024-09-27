package assignment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// Note: Source isn't used in this assignment
class Source {

    @JsonCreator
    private Source(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
    }

}
