package assignment;

// Used to hold the paths and links
enum InputFile {
    SIMPLE("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/Assignment 2/csc-305-assignment-2-WintonGee/project_2/inputs/simple.txt"),
    NEWSAPI("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/Assignment 2/csc-305-assignment-2-WintonGee/project_2/inputs/newsapi.txt"),
    URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=2940be2ecbcd45e7aac75d43cc779f7e"),
    HEADLINE("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/Assignment 2/csc-305-assignment-2-WintonGee/project_2/inputs/headline.txt");

    private final String filePath;

    /**
     * Constructs an InputFile object with the specified file path.
     *
     * @param filePath The path to the input file.
     */
    InputFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Path to the file
     * @return path to the file
     */
    public String getFilePath() {
        return filePath;
    }
}
