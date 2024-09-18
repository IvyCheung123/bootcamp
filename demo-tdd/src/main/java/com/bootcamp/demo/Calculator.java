package com.bootcamp.demo;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
  private List<Integer> integers;

  public Calculator() {
    this.integers = new ArrayList<>();
  }

  public Calculator(List<Integer> integers) {
    this.integers = integers;
  }

  public int sum() {
    // mapToInt() -> IntStream -> sum()
    if (this.integers.size() > 2)
      return this.integers.get(0);
    return this.integers.stream().mapToInt(e -> e.intValue()).sum();
  }
}
