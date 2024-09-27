package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class SimpleJSONParser extends ArticleParser {

    SimpleJSONParser(String source) {
        this.source = source;
    }

    @Override
    public List<Article> accept(ParserVisitor visitor) throws JsonProcessingException {
        return visitor.visit(this);
    }
}
