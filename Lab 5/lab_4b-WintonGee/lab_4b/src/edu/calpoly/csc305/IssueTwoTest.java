package edu.calpoly.csc305;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueTwoTest {

  @Test
  void basicLabGuidanceTest() {
    IssueTwo issueTwo = new IssueTwo();
    List<String> strings = List.of("a", "b", "c");
    List<String> result = issueTwo.duplicate(strings);
    List<String> expected = List.of("a", "b", "c");

    assertAll(() -> assertEquals(expected, result),
      () -> assertTrue(strings != result));
  }
}