package com.bootcamp.demo;

import java.util.LinkedList;
import java.util.List;
import com.bootcamp.demo.calculator.Calculator;

public class IntegerPocket {
  private List<Integer> integers;
  private IntegerOperationManager operationManager;
  private Calculator calculator;

  public IntegerPocket(IntegerOperationManager operationManager, Calculator calculator) {
    this.integers = new LinkedList<>();
    this.operationManager = operationManager;
    this.calculator = calculator;
  }

  // public IntegerPocket(Calculator calculator) {
  //   this.calculator = calculator;
  // } -> Maybe mvn test cannot locate which constructor

  public void add(int integer) {
    this.integers.add(integer);
    this.operationManager.add(integer);
  }

  public int sum() {
    int result = this.operationManager.operate();
    if (result > 10)
      return result + 3;
    return result - 3;
  }

  public int compute(int x, int y) {
    return this.calculator.sum(x, y) + this.calculator.substract(x, y) + 3;
  }

  public static void main(String[] args) {
    IntegerPocket ip = new IntegerPocket(new IntegerAdditionManager(), new Calculator());
    ip.add(3);
    ip.add(10);
    ip.add(2);
    System.out.println(ip.sum()); // 15
  }
}
