package assignment;

// This is used because I am having trouble figuring out why I can't
// just use bad.json or example.json even when I put them in the same package
enum InputFile {
    EXAMPLE("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/project-1-WintonGee/project_1/inputs/example.json"),
    BAD("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/project-1-WintonGee/project_1/inputs/bad.json");

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
