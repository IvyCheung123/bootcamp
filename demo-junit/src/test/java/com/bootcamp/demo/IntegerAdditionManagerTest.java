package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IntegerAdditionManagerTest {
  @Test
  void testSum() {
    IntegerAdditionManager iam = new IntegerAdditionManager();
    iam.add(3);
    iam.add(10);
    iam.add(2);
    int result = iam.sum();
    // assertEquals(15, result); // Day 1
    assertEquals(30, result); // Day 2
  }
}
