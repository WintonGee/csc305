package edu.calpoly.csc305;

import java.util.List;

// buildString taking in list Integer and String conflicts with each other (lists)
// this would work in the case that it was not taking in list and just Integer and String
public class IssueFour {
  /*
    You will need to update these methods to accomplish the intended task (there
    are a few ways to do this) and update the tests based on your solution.
   */

    public String buildString(List<?> list) {
        StringBuilder builder = new StringBuilder();

        for (Object o : list) {
            if (o instanceof String) {
                builder.append(String.format("string: %s\n", (String) o));
            } else if (o instanceof Integer) {
                builder.append(String.format("integer: %d\n", (Integer) o));
            }
        }

        return builder.toString();
    }


//  public String buildString(List<String> strings) {
//    StringBuilder builder = new StringBuilder();
//
//    for (String string : strings) {
//      builder.append(String.format("string: %s\n", string));
//    }
//
//    return builder.toString();
//  }
//
//  public String buildString(List<Integer> integers) {
//    StringBuilder builder = new StringBuilder();
//
//    for (Integer integer : integers) {
//      builder.append(String.format("integer: %d\n", integer));
//    }
//
//    return builder.toString();
//  }
}
