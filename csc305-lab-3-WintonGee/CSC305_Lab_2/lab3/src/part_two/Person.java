package part_two;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

class Person {
    private final String name;
    private final List<Award> awards = new ArrayList<>();
    private final List<String> knownFor = new ArrayList<>();

    @JsonCreator
    private Person(@JsonProperty("name") String name, @JsonProperty("awards") List<Award> awards, @JsonProperty("knownFor") List<String> knownFor) {
        this.name = name;
        this.awards.addAll(awards);
        this.knownFor.addAll(knownFor);
    }

    void printPerson() {
        // Display name
        System.out.println(this.name + '\n');

        // Display Known For
        System.out.println("Known For:");
        for (String kf : this.knownFor)
            System.out.println("        " + kf);

        // Display Awards
        System.out.println("\n Awards:");
        for (Award a : this.awards)
            System.out.println("        " + a.getName() + ", " + a.getYear());
    }
}
