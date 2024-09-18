package com.bootcamp.demo;

public class IntegerAdditionManager extends IntegerOperationManager {
  @Override
  public int operate() {
    int total = 0;
    for (Integer i : super.getIntegers()) {
      total += i;
    }
    return total;
  }
}
