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
//        fileNewsApiTest();
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
        SourceSpecification sourceSpecification = new SourceSpecification("file", "newsapi");
        // User should provide the path to the file
        String userInput = InputFile.NEWSAPI.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        List<Article> articles = parseHandler.getArticles();
        articles.forEach(System.out::println);
    }

    /**
     * This tests the functionality of file-simple
     * Demonstration initiates the parser for each user defined source, then display the articles
     *
     * @throws IOException Errors when unable to open Bad or Example input file
     */
    private static void fileSimpleTest() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("file", "simple");
        // User should provide the path to the file
        String userInput = InputFile.SIMPLE.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        List<Article> articles = parseHandler.getArticles();
        articles.forEach(System.out::println);
    }

    /**
     * This tests the functionality of url-newsapi
     * Demonstration initiates the parser for each user defined source, then display the articles
     *
     * @throws IOException Errors when unable to open URL
     */
    private static void urlNewsApiTest() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("url", "newsapi");
        // User should provide the URL
        String userInput = InputFile.URL.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        List<Article> articles = parseHandler.getArticles();
        articles.forEach(System.out::println);
    }


}
