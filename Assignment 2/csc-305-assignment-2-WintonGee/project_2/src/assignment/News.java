package assignment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class News {

    private final List<Article> articles;

    @JsonCreator
    private News(
            @JsonProperty("status") String status,
            @JsonProperty("totalResults") int totalResults,
            @JsonProperty("articles") List<Article> articles) {
        this.articles = articles;
    }

    /**
     * All articles after being parsed
     * @return list of articles, including the "invalid" ones
     */
    public List<Article> getArticles() {
        return this.articles;
    }
}
