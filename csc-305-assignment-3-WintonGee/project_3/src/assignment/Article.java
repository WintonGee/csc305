package assignment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Article {

    private final String title;
    private final String description;
    private final String url;
    private final String publishedAt;

    @JsonCreator
    private Article(
            @JsonProperty("source") Source source,
            @JsonProperty("author") String author,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("url") String url,
            @JsonProperty("urlToImage") String urlToImage,
            @JsonProperty("publishedAt") String publishedAt,
            @JsonProperty("content") String content) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishedAt = publishedAt;
    }

    String getTitle() {
        return this.title;
    }

    String getDescription() {
        return this.description;
    }

    String getUrl() {
        return this.url;
    }

    String getPublishedAt() {
        return this.publishedAt;
    }

    /**
     *
     * @return An appended string of all the required fields
     */
    @Override
    public String toString() {
        return "Title: " + this.title + "\n" +
                "Description: " + this.description + "\n" +
                "Published At: " + this.publishedAt + "\n" +
                "URL: " + this.url + "\n";
    }

}
