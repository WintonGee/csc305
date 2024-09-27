package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class NewsAPIJsonParser extends ArticleParser {

    NewsAPIJsonParser(String source) {
        this.source = source;
    }

    /**
     *
     * @param visitor Parser that is being accepted or used
     * @return The value after the visitor performs calculations
     * @throws JsonProcessingException Error processing the JSON input
     */
    @Override
    public List<Article> accept(ParserVisitor visitor) throws JsonProcessingException {
        return visitor.visit(this);
    }
}
