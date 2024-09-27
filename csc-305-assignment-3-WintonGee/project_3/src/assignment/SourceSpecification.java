package assignment;

public class SourceSpecification {

    private final String userSource; // either from a file or from a url
    private final String userFormat; // either newsapi or simple

    public SourceSpecification(String userSource, String userFormat) {
        this.userSource = userSource;
        this.userFormat = userFormat;
    }

    /**
     * Returns the user source value
     *
     * @return Returns the user source value
     */

    public String getUserSource() {
        return userSource;
    }

    /**
     * Returns the user format value
     *
     * @return Returns the user format value
     */
    public String getUserFormat() {
        return userFormat;
    }

}
