package part_two;

import com.fasterxml.jackson.databind.ObjectMapper;
import part_one.FilePath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = new ArrayList<>();
        for (FilePath filePath : FilePath.values()) {
            File file = new File(filePath.getPath());
            Person person = objectMapper.readValue(file, Person.class);
            people.add(person);
        }

        // Output all
        people.forEach(Person::printPerson);
    }
}
