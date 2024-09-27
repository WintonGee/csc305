package part_one;

public enum FilePath {
    ONE("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/csc305-lab-3-WintonGee/CSC305_Lab_2/input1.json"),
    TWO("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/csc305-lab-3-WintonGee/CSC305_Lab_2/input2.json"),
    THREE("/Users/wintongee/Desktop/School/Fall 2023/CSC305/Repos/csc305-lab-3-WintonGee/CSC305_Lab_2/input3.json");

    private final String path;

    FilePath(String s) {
        this.path = s;
    }

    public String getPath() {
        return this.path;
    }
}
