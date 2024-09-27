package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class SimpleJSONParser extends ArticleParser {

    SimpleJSONParser(String source) {
        this.source = source;
    }

    /**
     * Implementation of visitor method for SimpleParser
     *
     * @return list of articles after the simple parsing
     * @throws JsonProcessingException Error handling the json parsing
     */
    @Override
    public List<Article> visit() throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        Article article = objectMapper.readValue(this.source, Article.class);
        if (this.isValidArticle(article))
            articles.add(article);
        else
            this.logInvalidArticle(article);

        return articles;
    }
}
