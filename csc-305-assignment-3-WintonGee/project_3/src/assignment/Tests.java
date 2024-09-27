package assignment;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    // Tests for NewsAPIJsonParser
    /**
     * Test for valid inputs to verify that all articles are parsed.
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testValidInputs() throws IOException {
        String jsonString = "{\n" +
                "  \"status\": \"ok\",\n" +
                "  \"totalResults\": 38,\n" +
                "  \"articles\": [\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"cnn\",\n" +
                "        \"name\": \"CNN\"\n" +
                "      },\n" +
                "      \"author\": \"By <a href=\\\"/profiles/julia-hollingsworth\\\">Julia Hollingsworth</a>, CNN\",\n" +
                "      \"title\": \"The latest on the coronavirus pandemic and vaccines: Live updates - CNN\",\n" +
                "      \"description\": \"The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.\",\n" +
                "      \"url\": \"https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html\",\n" +
                "      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/200213175739-03-coronavirus-0213-super-tease.jpg\",\n" +
                "      \"publishedAt\": \"2021-03-24T22:32:00Z\",\n" +
                "      \"content\": \"A senior European diplomat is urging caution over the use of proposed new rules that would govern exports of Covid-19 vaccines to outside of the EU. The rules were announced by the European Commissio… [+2476 chars]\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = new NewsAPIJsonParser(jsonString).accept(visitor);

        assertEquals(articles.size(), 1);
        assertTrue(ArticleVerification.isAllArticlesValid(articles));
    }

    /**
     * Test for inputs with missing fields.
     *
     * @throws IOException if bad input does not exist
     */
    @Test
    void testNewsApiInputWithArticleMissingFields() throws IOException {
        String jsonString = "{\n" +
                "  \"status\": \"ok\",\n" +
                "  \"totalResults\": 38,\n" +
                "  \"articles\": [\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"cnn\",\n" +
                "        \"name\": \"CNN\"\n" +
                "      },\n" +
                "      \"author\": \"By <a href=\\\"/profiles/julia-hollingsworth\\\">Julia Hollingsworth</a>, CNN\",\n" +
                "      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/200213175739-03-coronavirus-0213-super-tease.jpg\",\n" +
                "      \"publishedAt\": \"2021-03-24T22:32:00Z\",\n" +
                "      \"content\": \"A senior European diplomat is urging caution over the use of proposed new rules that would govern exports of Covid-19 vaccines to outside of the EU. The rules were announced by the European Commissio… [+2476 chars]\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = new NewsAPIJsonParser(jsonString).accept(visitor);
        assertEquals(articles.size(), 0);
    }

    /**
     * Test for inputs with missing unused fields (Not inside articles).
     *
     * @throws IOException if bad input does not exist
     */
    @Test
    void testNewsApiInputWithMissingUnusedFields() throws IOException {
        String jsonString = "{\n" +
                "  \"totalResults\": 38,\n" +
                "  \"articles\": [\n" +
                "    {\n" +
                "      \"source\": {\n" +
                "        \"id\": \"cnn\",\n" +
                "        \"name\": \"CNN\"\n" +
                "      },\n" +
                "      \"author\": \"By <a href=\\\"/profiles/julia-hollingsworth\\\">Julia Hollingsworth</a>, CNN\",\n" +
                "      \"title\": \"The latest on the coronavirus pandemic and vaccines: Live updates - CNN\",\n" +
                "      \"description\": \"The coronavirus pandemic has brought countries to a standstill. Meanwhile, vaccinations have already started in some countries as cases continue to rise. Follow here for the latest.\",\n" +
                "      \"url\": \"https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html\",\n" +
                "      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/200213175739-03-coronavirus-0213-super-tease.jpg\",\n" +
                "      \"publishedAt\": \"2021-03-24T22:32:00Z\",\n" +
                "      \"content\": \"A senior European diplomat is urging caution over the use of proposed new rules that would govern exports of Covid-19 vaccines to outside of the EU. The rules were announced by the European Commissio… [+2476 chars]\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = new NewsAPIJsonParser(jsonString).accept(visitor);

        assertEquals(articles.size(), 1);
        assertTrue(ArticleVerification.isAllArticlesValid(articles));
    }

    /**
     * Test for empty json
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testEmptyNewsApiInput() throws IOException {
        String jsonString = "{}";

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = new NewsAPIJsonParser(jsonString).accept(visitor);

        assertEquals(articles.size(), 0);
    }

    // Note: This imitates what the headline URL would return
    // I could use mock... but that wouldn't make much sense to use
    /**
     * Test for json retrieved through URL using imitation for consistency
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testHeadlineNewsApiInput() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("file", "newsapi");
        String userInput = InputFile.HEADLINE.getFilePath();
        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        List<Article> articles = parseHandler.getArticles();
        assertEquals(articles.size(), 16);
        assertTrue(ArticleVerification.isAllArticlesValid(articles));
    }


    /**
     * Test for json retrieved through URL
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testHeadlineNewsApiInput_2() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("url", "newsapi");
        String userInput = InputFile.URL.getFilePath();
        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        List<Article> articles = parseHandler.getArticles();
        assertTrue(ArticleVerification.isAllArticlesValid(articles));
        // Note: Unable to check number of articles since it is dynamic
    }

    // Tests for SimpleJsonParser
    /**
     * Test for valid inputs to verify that all articles are parsed.
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testValidFileSimpleInputs() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("file", "simple");
        String userInput = InputFile.SIMPLE.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        List<Article> articles = parseHandler.getArticles();
        assertEquals(articles.size(), 1);
        assertTrue(ArticleVerification.isAllArticlesValid(articles));
    }

    /**
     * Test for empty inputs
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testEmptySimpleInput() throws IOException {
        String jsonString = "{}";

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = new SimpleJSONParser(jsonString).accept(visitor);

        assertEquals(articles.size(), 0);
    }

    /**
     * Test for invalid inputs.
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testInvalidInput() throws IOException {
        String jsonString = "{\n" +
                "  \"description\": \"Extend Assignment #1 to support multiple sources and to introduce source processor.\",\n" +
                "  \"publishedAt\": \"2021-04-16 09:53:23.709229\"\n" +
                "}";

        ParserVisitor visitor = new ParserVisitorImplementation();
        List<Article> articles = new SimpleJSONParser(jsonString).accept(visitor);
        assertEquals(articles.size(), 0);
    }


    // Tests for visitors
    // Instructions: To clarify, the test here is to validate that
    // the set of parsers created is consistent with the input configuration

    /**
     * Tests if the input configuration is consistent with the returned parser: file-newsapi
     *
     * @throws IOException File errors occur
     */
    @Test
    void testVisitorFileNewsApi() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("file", "newsapi");
        String userInput = InputFile.NEWSAPI.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        ArticleParser parserVisitor = parseHandler.getArticleParser();

        assertTrue(parserVisitor instanceof NewsAPIJsonParser);
    }

    /**
     * Tests if the input configuration is consistent with the returned parser: url-newsapi
     *
     * @throws IOException File errors occur
     */
    @Test
    void testVisitorUrlNewsApi() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("url", "newsapi");
        String userInput = InputFile.URL.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        ArticleParser parserVisitor = parseHandler.getArticleParser();

        assertTrue(parserVisitor instanceof NewsAPIJsonParser);
    }

    /**
     * Tests if the input configuration is consistent with the returned parser: file-simple
     *
     * @throws IOException File errors occur
     */
    @Test
    void testVisitorFileSimple() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("file", "simple");
        String userInput = InputFile.SIMPLE.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        ArticleParser parserVisitor = parseHandler.getArticleParser();

        assertTrue(parserVisitor instanceof SimpleJSONParser);
    }

    /**
     * // Test for invalid User Format
     *
     * @throws IOException File errors occur
     */
    @Test
    void testVisitorInvalidFormat() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("file", "wrong");
        String userInput = InputFile.SIMPLE.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        assertThrows(IllegalArgumentException.class, parseHandler::getArticleParser);
    }


    // Test for invalid User Source
    /**
     * // Test for invalid User Format
     *
     * @throws IOException File errors occur
     */
    @Test
    void testVisitorInvalidSource() throws IOException {
        SourceSpecification sourceSpecification = new SourceSpecification("wrongsource", "simple");
        String userInput = InputFile.SIMPLE.getFilePath();

        ParseHandler parseHandler = new ParseHandler(sourceSpecification, userInput);
        assertThrows(IllegalArgumentException.class, parseHandler::getArticleParser);
    }

}
