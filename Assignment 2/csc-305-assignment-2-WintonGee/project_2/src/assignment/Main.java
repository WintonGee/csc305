package assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Check - Parser: Design - SOLID
// Check - Parser: Functionality - Looks good to me
// Check - Testing - DONE
// Check - Main method - DONE
// Check - Documentation - DONE

// Questions
// - Should I have multiple tests for headline?
// - Do I need a separate parser for URL if it should return the same JSON format as newsapi - NO
class Main {

    /**
     * Static to initialize the Logger for the "main" class.
     * Logger to log messages to a file named "ArticleLogs.log".
     * If any issues to initialize the logger, it logs a severe message.
     */
    static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("ArticleLogs.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
    }

    /**
     * Main method is used to run the program
     *
     * @param args No input needed for this program to run
     * @throws IOException Errors when unable to open Bad or Example input file
     */
    public static void main(String[] args) throws IOException {
        simpleTest();
        newsApiTest();
        urlNewsApiTest();
    }

    /**
     * Used for testing the simple format
     * @throws IOException Error opening file
     */
    private static void simpleTest() throws IOException {
        String stringJson = Files.readString(Paths.get(InputFile.SIMPLE.getFilePath()));
        ArticleParser jsonParser = new SimpleJSONParser();
        jsonParser.parse(stringJson).forEach(System.out::println);
    }

    /**
     * Used for testing the news API method
     * @throws IOException Error opening file
     */
    private static void newsApiTest() throws IOException {
        String stringJson = Files.readString(Paths.get(InputFile.NEWSAPI.getFilePath()));
        ArticleParser jsonParser = new NewsAPIJSONParser();
        jsonParser.parse(stringJson).forEach(System.out::println);
    }

    /**
     * Used for testing the URL News API Method
     */
    private static void urlNewsApiTest() {
        try {
            URL apiUrl = new URL(InputFile.URL.getFilePath());
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            Scanner scanner = new Scanner(connection.getInputStream(), StandardCharsets.UTF_8);
            String response = scanner.useDelimiter("\\A").next();

            ArticleParser jsonParser = new NewsAPIJSONParser();
            jsonParser.parse(response).forEach(System.out::println);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}