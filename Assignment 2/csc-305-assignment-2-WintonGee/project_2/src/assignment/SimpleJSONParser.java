package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class SimpleJSONParser extends ArticleParser {

    /**
     * Parses the provided json into a list of valid articles
     * @param simpleJson the provided json in string form
     * @return a list of valid articles
     * @throws JsonProcessingException error occurred while processing json string
     */
    @Override
    public List<Article> parse(String simpleJson) throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        Article article = objectMapper.readValue(simpleJson, Article.class);
        if (isValidArticle(article))
            articles.add(article);
        else
            logInvalidArticle(article);

        return articles;
    }

}
