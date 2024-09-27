package edu.calpoly.csc305;

import java.util.ArrayList;
import java.util.List;

// ? is wildcard, use T to specify a specific return type
// Changed the ? to T
public class IssueTwo {
    /**
     * Method to illustrate common issue with generics.
     *
     * @param items list to copy
     * @return duplicate of input list
     */
    public <T> List<T> duplicate(List<T> items) {
        List<T> copy = new ArrayList<>();

        for (T item : items) {
            copy.add(item);
        }

        return copy;
    }
}
