package part_one;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        List<Person> people = new ArrayList<>();
        for (FilePath filePath : FilePath.values()) {
            // Reading data from file
            FileReader fr = new FileReader(filePath.getPath());
            JSONTokener jToken = new JSONTokener(fr);
            JSONObject jsonData = new JSONObject(jToken);

            // Parser to retrieve data for Person input params
            JsonParser parser = new JsonParser(jsonData);
            String name = parser.getName();
            List<String> knownFor = parser.getKnownFor();
            List<Award> awards = parser.getAwards();

            // Creating and adding the person
            Person person = new Person(name, awards, knownFor);
            people.add(person);
        }

        // Output all
        people.forEach(Person::printPerson);
    }

}