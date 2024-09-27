package assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ParseHandler {

    private final SourceSpecification sourceSpecification;
    private final String userInput;

    ParseHandler(SourceSpecification sourceSpecification, String userInput) {
        this.sourceSpecification = sourceSpecification;
        this.userInput = userInput;
    }

    // Not private because used for testing
    List<Article> getArticles() throws IOException {
        ArticleParser simpleJSONParser = getArticleParser();

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = simpleJSONParser.accept(visitor);

        return articles;
    }


    // Not private because used for testing
    ArticleParser getArticleParser() throws IOException {
        if (sourceSpecification.getUserFormat().equalsIgnoreCase("newsapi")) {
            return new NewsAPIJsonParser(this.getJsonString());
        } else if (sourceSpecification.getUserFormat().equalsIgnoreCase("simple")) {
            return new SimpleJSONParser(this.getJsonString());
        }

        throw new IllegalArgumentException("Invalid Format Type");
    }


    private String getJsonString() throws IOException {
        if (sourceSpecification.getUserSource().equalsIgnoreCase("file")) {
            return Files.readString(Paths.get(this.userInput));
        } else if (sourceSpecification.getUserSource().equalsIgnoreCase("url")) {
            URL apiUrl = new URL(userInput);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream(), StandardCharsets.UTF_8);
            return scanner.useDelimiter("\\A").next();
        }

        throw new IllegalArgumentException("Invalid Source Type");
    }

}
