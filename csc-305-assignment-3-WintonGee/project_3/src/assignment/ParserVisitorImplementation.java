package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ParserVisitorImplementation implements ParserVisitor {

    /**
     * Implementation of visit for newsAPI format
     *
     * @param newsAPIJsonParser Parser for newsapi
     * @return List of articles
     * @throws JsonProcessingException
     */

    @Override
    public List<Article> visit(NewsAPIJsonParser newsAPIJsonParser) throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(newsAPIJsonParser.source);
        if (rootNode.has("articles")) {
            JsonNode articlesNode = rootNode.get("articles");
            for (JsonNode articleNode : articlesNode) {
                Article article = objectMapper.treeToValue(articleNode, Article.class);
                if (newsAPIJsonParser.isValidArticle(article)) {
                    articles.add(article);
                } else {
                    newsAPIJsonParser.logInvalidArticle(article);
                }
            }
        }

        return articles;
    }

    /**
     * Implementation of visit for simple format
     *
     * @param simpleJSONParser Parser for simple
     * @return List of articles
     * @throws JsonProcessingException
     */
    @Override
    public List<Article> visit(SimpleJSONParser simpleJSONParser) throws JsonProcessingException {
        List<Article> articles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        Article article = objectMapper.readValue(simpleJSONParser.source, Article.class);
        if (simpleJSONParser.isValidArticle(article))
            articles.add(article);
        else
            simpleJSONParser.logInvalidArticle(article);

        return articles;
    }
}
