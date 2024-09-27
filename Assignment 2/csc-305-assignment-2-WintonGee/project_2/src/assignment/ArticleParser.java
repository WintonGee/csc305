package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

// A parser returns a list of articles (from the previous assignment)
// but may process those articles in some way before returning that list.
public abstract class ArticleParser {

    /**
     * This is an abstract method for parsing
     * @param source json input
     * @return A list of articles
     * @throws JsonProcessingException Error processing the json
     */
    abstract List<Article> parse(String source) throws JsonProcessingException;

    /**
     * Check if an article is valid by ensuring that required fields are not null.
     *
     * @param article The article to validate.
     * @return True if the article is valid, false otherwise.
     */
    boolean isValidArticle(Article article) {
        return article.getTitle() != null
                && article.getDescription() != null
                && article.getPublishedAt() != null
                && article.getUrl() != null;
    }

    /**
     * Log warning message for invalid article, append missing fields.
     *
     * @param article The invalid article.
     */
    void logInvalidArticle(Article article) {
        StringBuilder stringBuilder = new StringBuilder("Invalid Required Fields: ");
        if (article.getTitle() == null) {
            stringBuilder.append("Title ");
        }
        if (article.getDescription() == null) {
            stringBuilder.append("Description ");
        }
        if (article.getPublishedAt() == null) {
            stringBuilder.append("Published At ");
        }
        if (article.getUrl() == null) {
            stringBuilder.append("URL ");
        }
        Main.logger.warning(stringBuilder.toString());
    }

}
