package com.bootcamp.demo;

import java.util.LinkedList;
import java.util.List;

public abstract class IntegerOperationManager {
  private List<Integer> integers;

  public IntegerOperationManager() {
    this.integers = new LinkedList<>();
  }

  public void add(int value) {
    this.integers.add(value);
  }

  public int sum() {
    int total = 0;
    for (Integer i : this.integers) {
      total += i;
    }
    // return total; // Day 1
    return total * 2; // Day 2 -> only affect IntegerOperationManagerTest
  }

  public List<Integer> getIntegers() {
    return this.integers;
  }

  public abstract int operate();
}
