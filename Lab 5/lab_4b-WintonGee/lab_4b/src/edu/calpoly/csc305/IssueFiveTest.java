package edu.calpoly.csc305;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueFiveTest {

  @Test
  void basicLabGuidanceTestIntegers() {
    IssueFive issueFive = new IssueFive();
    long expected = 27;
    long result = issueFive.sumIntsAsLongs(List.of(1, 2, 20, 4));

    assertEquals(expected, result);
  }

  @Test
  void basicLabGuidanceTestDoubles() {
    IssueFive issueFive = new IssueFive();
    long expected = 27;
    long result = issueFive.sumDoublesAsLongs(List.of(1.21, 2.4, 20.9, 4.2));

    assertEquals(expected, result);
  }
}