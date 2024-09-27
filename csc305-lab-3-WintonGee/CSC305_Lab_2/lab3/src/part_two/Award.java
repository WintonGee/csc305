package part_two;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Award {
    private final String name;
    private final int year;

    @JsonCreator
    private Award(@JsonProperty("name") String name, @JsonProperty("year") int year) {
        this.name = name;
        this.year = year;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }
}
