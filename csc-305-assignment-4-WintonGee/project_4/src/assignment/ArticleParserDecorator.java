package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Iterator;
import java.util.List;

// Note: This assumes that this class will only be used for the newsAPI
public class ArticleParserDecorator extends ArticleParser {

    private final ArticleParser p;
    private final String sourceFilter;

    ArticleParserDecorator(ArticleParser p, String sourceFilter) {
        this.p = p;
        this.sourceFilter = sourceFilter;
    }

    /**
     * This method expects to use the newsAPI parse method, then applies the source filter
     *
     * @return List of articles after applying the filter
     * @throws JsonProcessingException Error with handling the json
     */
    @Override
    public List<Article> visit() throws JsonProcessingException {
        List<Article> list = p.visit(); // This should use the NewsAPIParser
        list.removeIf(article -> !article.getSource().getName().equals(sourceFilter));
        return list;
    }
}
