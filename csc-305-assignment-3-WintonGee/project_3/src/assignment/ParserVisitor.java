package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ParserVisitor {

    /**
     * Visit method for parsing newsApi formats
     *
     * @param newsAPIJsonParser Parser for newsapi
     * @return List of articles
     * @throws JsonProcessingException error with json processing
     */
    List<Article> visit(NewsAPIJsonParser newsAPIJsonParser) throws JsonProcessingException;

    /**
     * Visit method for parsing simple formats
     *
     * @param simpleJSONParser Parser for simple
     * @return List of articles
     * @throws JsonProcessingException  error with json processing
     */
    List<Article> visit(SimpleJSONParser simpleJSONParser) throws JsonProcessingException;

}
