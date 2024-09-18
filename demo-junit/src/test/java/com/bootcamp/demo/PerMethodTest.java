package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;

// !!! In test code base, we define the test class based on "Testing Environment"
// This class "PerMethodTest" is a "Testing Environment"
// test.class need to end with "Test" for mvn test to identify
// x represents something like environment, e.g. successful or fail counting

// TestInstance is "per method" by default -> two different environment
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PerMethodTest {
  private int x;

  // @BeforeAll & @AfterAll -> must static -> run once only -> must not use instance object
  @BeforeAll // !!! Before all test cases
  static void open() {
    System.out.println("Before all test cases ...");
  }

  @AfterAll // !!! After all test cases
  static void close() {
    System.out.println("After all test cases ...");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("Before each test case ... Can be used to reset something ...");
  }

  @AfterEach
  void afterEach() {
    System.out.println("After each test case ... Can be used to reset something ...");
  }

  @Test
  void test() {
    System.out.println("test()");
    this.x++;
    assertEquals(1, this.x);
  }

  @Test
  void test2() {
    System.out.println("test2()");
    this.x++;
    assertEquals(1, this.x);
  }

  // For reference only
  // Junit Framework generate "test code", something like ...
  public static void main(String[] args) {
    PerMethodTest.open();

    // pmt1 is a TestInstance, while pmt2 is another TestInstance, so it is a "Per Method" Testing Environment
    PerMethodTest pmt1 = new PerMethodTest();
    pmt1.beforeEach();
    pmt1.test();
    pmt1.afterEach();

    PerMethodTest pmt2 = new PerMethodTest(); // x is an attribute belongs to object
    pmt2.beforeEach();
    pmt2.test2(); // so x is reset
    pmt2.afterEach();

    PerMethodTest.close();
  }
}
