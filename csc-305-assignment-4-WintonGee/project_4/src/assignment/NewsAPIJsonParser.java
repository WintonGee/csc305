package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class NewsAPIJsonParser extends ArticleParser {

    NewsAPIJsonParser(String source) {
        this.source = source;
    }

    /**
     * Implementation of visitor method for NewsAPIJsonParser
     *
     * @return list of articles after the simple parsing
     * @throws JsonProcessingException Error handling the json parsing
     */
    @Override
    public List<Article> visit() throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(this.source);
        if (rootNode.has("articles")) {
            JsonNode articlesNode = rootNode.get("articles");
            for (JsonNode articleNode : articlesNode) {
                Article article = objectMapper.treeToValue(articleNode, Article.class);
                if (this.isValidArticle(article)) {
                    articles.add(article);
                } else {
                    this.logInvalidArticle(article);
                }
            }
        }

        return articles;
    }
}
