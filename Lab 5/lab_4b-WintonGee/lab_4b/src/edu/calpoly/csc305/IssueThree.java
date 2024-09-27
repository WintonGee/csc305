package edu.calpoly.csc305;

import java.util.ArrayList;
import java.util.List;

// ? extends String, indicates wildcard, but type (String) is known,
// so no point to wildcard extends String, just do strings
public class IssueThree {

    private final IssueThreeData data;

    public IssueThree(IssueThreeData data) {
        this.data = data;
    }

    public int count() {
    List<? extends String> strings = data.strings();
//        List<String> strings = new ArrayList<>(data.strings());

        // Commented this out because it affects the testing
//    strings.add("zoinks");
//    strings.set(0, "nope");

        return strings.size();
    }

}
