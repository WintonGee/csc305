package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SourceSpecification {


    enum SOURCE {file, URL}

    enum FORMAT {newsAPI, simple}

    private final SOURCE userSource; // either from a file or from a url
    private final FORMAT userFormat; // either newsapi or simple
    private final String sourceFilter; // Used for filtering out sources

    /**
     * @param userSource   user provides either file or URL source type
     * @param userFormat   user provides either newsApi or Simple format
     * @param sourceFilter user provides source filter, used only with newsApi
     */
    SourceSpecification(SOURCE userSource, FORMAT userFormat, String sourceFilter) {
        this.userSource = userSource;
        this.userFormat = userFormat;
        this.sourceFilter = sourceFilter;
    }

    /**
     * Method is used for running the parser
     *
     * @param json The json data being parsed
     * @return A list of articles after the visit and accept
     * @throws IOException Error with parsing the json
     */
    List<Article> runParser(String json) throws IOException {
        ArticleParser parser = getParser(json);
        return accept(parser);
    }

    /**
     * Method is used to run the visit of the parser
     *
     * @param p Parser being used
     * @return List of valid articles
     * @throws JsonProcessingException Error with handling the json
     */
    List<Article> accept(ArticleParser p) throws JsonProcessingException {
        return p.visit();
    }

    /**
     * Returns the parser based on the user's input
     *
     * @param json JSON that is being parsed
     * @return Parser that will be used to handling parsing
     */
    ArticleParser getParser(String json) {
        // Note: sourceFile is not used for the simple format
        if (userSource == SOURCE.file && userFormat == FORMAT.simple) {
            return new SimpleJSONParser(json);
        } else if (userFormat == FORMAT.newsAPI) {
            // Decorator is used here because we want to decorate the existing NewsAPI parser
            NewsAPIJsonParser nwp = new NewsAPIJsonParser(json);
            return new ArticleParserDecorator(nwp, this.sourceFilter);
        }

        throw new IllegalArgumentException("Invalid arguments");
    }

    /**
     * This method returns the json data that will be parsed based on user inputs
     *
     * @param pathInput The path being used to get json
     * @return The json data that will be parsed
     * @throws IOException error handling
     */
    String getJsonString(String pathInput) throws IOException {
        if (userSource == SOURCE.file) {
            return Files.readString(Paths.get(pathInput));
        }

        // Must be url since we are using enum
        URL apiUrl = new URL(pathInput);
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("GET");

        Scanner scanner = new Scanner(connection.getInputStream(), StandardCharsets.UTF_8);
        return scanner.useDelimiter("\\A").next();
    }

}
