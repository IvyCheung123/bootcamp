package com.bootcamp.demo;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  // private Calculator calculator;

  @Test
  void testSum() {
    // assertEquals(15, new Calculator(Arrays.asList(3, 10, 2)).sum());
    // assertEquals(99, new Calculator(Arrays.asList(-3, 100, 2)).sum());
    assertEquals(3, new Calculator(Arrays.asList(1, 2)).sum());

    // Requirement change: the number of integer > 2, return first element
    assertEquals(1, new Calculator(Arrays.asList(1, 2, 3)).sum());
    assertEquals(0, new Calculator(Arrays.asList()).sum());
 }
}
