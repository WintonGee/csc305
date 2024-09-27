package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
     * @param args No input needed for this program to run
     * @throws IOException Errors when unable to open Bad or Example input file
     */
    public static void main(String[] args) throws IOException {
        badTest();
        exampleTest();
    }

    private static void badTest() throws IOException {
        String stringJson = Files.readString(Paths.get(InputFile.BAD.getFilePath()));
        JSONParser jsonParser = new JSONParser(stringJson);
        jsonParser.getArticles().forEach(System.out::println);
    }

    private static void exampleTest() throws IOException {
        String stringJson = Files.readString(Paths.get(InputFile.EXAMPLE.getFilePath()));
        JSONParser jsonParser = new JSONParser(stringJson);
        jsonParser.getArticles().forEach(System.out::println);
    }

}