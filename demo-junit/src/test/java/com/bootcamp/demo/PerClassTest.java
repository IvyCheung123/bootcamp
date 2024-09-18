package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PerClassTest {
  private int x;

  // @BeforeAll
  // static void open() {
  //   System.out.println("Before all test cases ...");
  // }

  // @AfterAll
  // static void close() {
  //   System.out.println("After all test cases ...");
  // }

  @BeforeAll
  void open() {
    System.out.println("Before all test cases ...");
  }

  @AfterAll
  void close() {
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
  @Order(2)
  void test() {
    System.out.println("test()");
    this.x++;
    assertEquals(2, this.x);
  }

  @Test
  @Order(1)
  void test2() {
    System.out.println("test2()");
    this.x++;
    assertEquals(1, this.x);
  }

  // For reference only
  // Junit Framework generate "test code", something like ...
  public static void main(String[] args) {
    // PerClassTest.open();

    PerClassTest pct1 = new PerClassTest();

    // @BeforeAll & @AfterAll can be written as instance void method in "Per Class" Testing Environment
    // PerClassTest.open();
    pct1.open();

    pct1.beforeEach();
    pct1.test2(); // test2() go first
    pct1.afterEach();

    pct1.beforeEach();
    pct1.test();
    pct1.afterEach();
    
    pct1.close();
    // PerClassTest.close();
  }
}
