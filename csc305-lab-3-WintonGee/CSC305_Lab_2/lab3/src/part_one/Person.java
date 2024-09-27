package part_one;

import java.util.ArrayList;
import java.util.List;

class Person {
    private final String name;
    private final List<Award> awards = new ArrayList<>();
    private final List<String> knownFor = new ArrayList<>();

    Person(String name, List<Award> awards, List<String> knownFor) {
        this.name = name;
        this.awards.addAll(awards);
        this.knownFor.addAll(knownFor);
    }

    void printPerson() {
        // Display name
        System.out.println('\n' + this.name + '\n');

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
