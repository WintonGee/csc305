package assignment;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleJSONParserTest {

    /**
     * Test for valid inputs to verify that all articles are parsed.
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testValidInputs() throws IOException {
        String jsonString = "{\n" +
                "  \"description\": \"Extend Assignment #1 to support multiple sources and to introduce source processor.\",\n" +
                "  \"publishedAt\": \"2021-04-16 09:53:23.709229\",\n" +
                "  \"title\": \"Assignment #2\",\n" +
                "  \"url\": \"https://canvas.calpoly.edu/courses/55411/assignments/274503\"\n" +
                "}";

        ArticleParser jsonParser = new SimpleJSONParser();
        List<Article> articles = jsonParser.parse(jsonString);
        assertEquals(articles.size(), 1);
    }

    /**
     * Test for empty inputs
     *
     * @throws IOException if example input does not exist
     */
    @Test
    void testEmptyInput() throws IOException {
        String jsonString = "{}";

        ArticleParser jsonParser = new SimpleJSONParser();
        List<Article> articles = jsonParser.parse(jsonString);
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

        ArticleParser jsonParser = new SimpleJSONParser();
        List<Article> articles = jsonParser.parse(jsonString);
        assertEquals(articles.size(), 0);
    }

}
