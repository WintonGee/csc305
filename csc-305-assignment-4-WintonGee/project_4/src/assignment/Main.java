package assignment;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

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
        fileNewsApiTest();
//        fileSimpleTest();
//        urlNewsApiTest();
    }

    /**
     * This tests the functionality of file-newsapi
     * Demonstration initiates the parser for each user defined source, then display the articles
     *
     * @throws IOException Errors when unable to open Bad or Example input file
     */
    private static void fileNewsApiTest() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification(SourceSpecification.SOURCE.file, SourceSpecification.FORMAT.newsAPI, "CNN");
        // User should provide the path to the file
        String pathInput = InputFile.NEWSAPI.getFilePath();
        String json = sourceSpecification.getJsonString(pathInput);

        List<Article> articles = sourceSpecification.runParser(json);
        articles.forEach(System.out::println);
    }

    /**
     * This tests the functionality of file-simple
     * Demonstration initiates the parser for each user defined source, then display the articles
     *
     * @throws IOException Errors when unable to open Bad or Example input file
     */
    private static void fileSimpleTest() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification(SourceSpecification.SOURCE.file, SourceSpecification.FORMAT.simple, "CNN");
        // User should provide the path to the file
        String pathInput = InputFile.NEWSAPI.getFilePath();
        String json = sourceSpecification.getJsonString(pathInput);

        List<Article> articles = sourceSpecification.runParser(json);
        articles.forEach(System.out::println);
    }

    /**
     * This tests the functionality of url-newsapi
     * Demonstration initiates the parser for each user defined source, then display the articles
     *
     * @throws IOException Errors when unable to open URL
     */
    private static void urlNewsApiTest() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification(SourceSpecification.SOURCE.URL, SourceSpecification.FORMAT.newsAPI, "CNN");
        // User should provide the URL
        String pathInput = InputFile.NEWSAPI.getFilePath();
        String json = sourceSpecification.getJsonString(pathInput);

        List<Article> articles = sourceSpecification.runParser(json);
        articles.forEach(System.out::println);
    }


}
