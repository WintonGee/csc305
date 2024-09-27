package assignment;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public abstract class ArticleParser {

    public String source;

    public abstract List<Article> visit() throws JsonProcessingException;

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
