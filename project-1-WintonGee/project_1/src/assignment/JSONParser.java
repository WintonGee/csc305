package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

class JSONParser {

    private final String jsonInput;

    /**
     * Constructs JSONParser object with provided JSON input.
     *
     * @param jsonInput The JSON input that will be parsed by the JSONParser.
     */
    JSONParser(String jsonInput) {
        this.jsonInput = jsonInput;
    }

    /**
     * Parse JSON input and return list of valid articles and log warnings for invalid articles.
     *
     * @return List of valid articles
     * @throws JsonProcessingException If there is an issue parsing JSON input.
     */
    public List<Article> getArticles() throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        News news = objectMapper.readValue(jsonInput, News.class);

        for (Article article : news.getArticles())
            if (article.isValid())
                articles.add(article);
            else
                Main.logger.warning("Invalid Required Fields: " + article.getInvalidFields());
        return articles;
    }

}
