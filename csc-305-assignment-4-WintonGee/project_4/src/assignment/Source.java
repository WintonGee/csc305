package assignment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// Note: Source isn't used in this assignment
class Source {

    private final String name;

    @JsonCreator
    private Source(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name) {
        this.name = name;
    }

    /**
     * Returns the name of the source
     * @return Name of the source
     */
    public String getName() {
        return this.name;
    }

}
