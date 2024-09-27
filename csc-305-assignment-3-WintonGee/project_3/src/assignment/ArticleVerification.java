package assignment;

import java.util.List;

// This class is a helper used for verifying that the articles are valid
public class ArticleVerification {

    /**
     * This checks that all the provided articles are valid articles
     * This funtion is used for the test cases
     *
     * @param articles The articles to check
     * @return If all the provided articles are valid
     */
    public static boolean isAllArticlesValid(List<Article> articles) {
        return articles.stream().allMatch(article ->
                article.getTitle() != null
                        && article.getDescription() != null
                        && article.getPublishedAt() != null
                        && article.getUrl() != null
        );
    }

}
