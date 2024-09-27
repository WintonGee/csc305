package edu.calpoly.csc305;

import java.util.List;

// - This is the case where a wildcard should be used
// - This line: total += number.longValue();
//   also assumed that Number can be converted to long type even with the double input
public class IssueFive {

    public long sumAsLongs(List<? extends Number> numbers) {
        long total = 0;

        for (Number number : numbers) {
            total += number.longValue();
        }

        return total;
    }

    public long sumIntsAsLongs(List<Integer> ints) {
        return sumAsLongs(ints);
    }

    public long sumDoublesAsLongs(List<Double> doubles) {
        return sumAsLongs(doubles);
    }
}
