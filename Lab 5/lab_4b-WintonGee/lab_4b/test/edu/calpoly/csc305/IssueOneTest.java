package edu.calpoly.csc305;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueOneTest {

  @Test
  void basicLabGuidanceTest() {
    IssueOne issueOne = new IssueOne();

    assertEquals(List.of("one", "two"), issueOne.getItems());
  }
}