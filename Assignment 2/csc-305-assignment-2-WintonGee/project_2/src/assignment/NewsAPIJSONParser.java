package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

class NewsAPIJSONParser extends ArticleParser {

    /**
     * Parses the provided json into a list of valid articles
     * @param newsJson the provided json in string form
     * @return a list of valid articles
     * @throws JsonProcessingException error occurred while processing json string
     */
    @Override
    public List<Article> parse(String newsJson) throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(newsJson);
        if (rootNode.has("articles")) {
            JsonNode articlesNode = rootNode.get("articles");
            for (JsonNode articleNode : articlesNode) {
                Article article = objectMapper.treeToValue(articleNode, Article.class);
                if (isValidArticle(article)) {
                    articles.add(article);
                } else {
                    logInvalidArticle(article);
                }
            }
        }

        return articles;
    }



}
