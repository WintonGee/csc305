package edu.calpoly.csc305;

import java.util.ArrayList;
import java.util.List;

// This was missing the <String>
public class IssueOne {

    /**
     * Method to illustrate common issue with generics.
     *
     * @return default list of items
     */
    public List<String> getItems() {
        ArrayList<String> items = new ArrayList<>();

        items.add("one");
        items.add("two");

        return items;
    }

}
