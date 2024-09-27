package assignment;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONParserTest {

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

        JSONParser jsonParser = new JSONParser(jsonString);
        List<Article> articles = jsonParser.getArticles();
        assertEquals(articles.size(), 1);
    }

    /**
     * Test for inputs with missing fields.
     *
     * @throws IOException if bad input does not exist
     */
    @Test
    void testInputWithMissingFields() throws IOException {
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

        JSONParser jsonParser = new JSONParser(jsonString);
        List<Article> articles = jsonParser.getArticles();
        assertEquals(articles.size(), 0);
    }

}
