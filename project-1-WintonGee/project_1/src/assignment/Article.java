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

    /**
     * This returns if the required values are there
     * title, description, published date-time, url
     * @return If the required inputs are valid
     */
    public boolean isValid() {
        return this.title != null && this.description != null && publishedAt != null && url != null;
    }

    /**
     * This will return invalid required fields as a String
     * @return An appended string of all the invalid fields
     */
    public String getInvalidFields() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.title == null)
            stringBuilder.append("Title ");
        if (this.description == null)
            stringBuilder.append("Description ");
        if (this.publishedAt == null)
            stringBuilder.append("Published At ");
        if (this.url == null)
            stringBuilder.append("URL ");
        return stringBuilder.toString();
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
