package com.bootcamp.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bootcamp.demo.calculator.Calculator;

// Test Instance -> Per Method
@ExtendWith(MockitoExtension.class)
public class IntegerPocketTest {
  // Inject a fake object (all instance methods without actual implementation)
  @Mock
  private IntegerOperationManager operationManager;

  // 1. Look for a constructor to create IntegerPocket object
  // public IntegerPocket(IntegerOperationManager operationManager)
  // 2. Look for IntegerOperationManger object
  // You have mocked the IntegerOperationManger object
  // 3. Create the IntegerPocket object
  @InjectMocks
  private IntegerPocket integerPocket;

  // Inject a real object (all instance methods with actual implementation)
  // You can override calculator.sum() but still remain actual calculator.substract()
  @Spy
  private Calculator calculator;

  @Test
  void testSum() {
    // Assumption
    Mockito.when(this.operationManager.operate()).thenReturn(11);
    // IntegerPocket.sum() will call operationManager.sum()
    // IntegerPocket.sum() = operationManager.sum() + 3
    // This mock return operationManager.sum() = -1
    // so -1 + 3 = 2

    // Real Test: Test IntegerPocket.sum() only, not care about operationManager.sum()
    // IntegerPocket ip = new IntegerPocket(this.operationManager); // after @InjectMocks
    this.integerPocket.add(3);
    this.integerPocket.add(10);
    this.integerPocket.add(2);
    int result = this.integerPocket.sum();
    assertEquals(14, result); // 11 + 3 = 14

    // Verify if the process of integerPocket.sum() touch and call operationManager.operate()
    verify(this.operationManager, times(1)).operate();
  }

  @Test
  void testSum2() {
    Mockito.when(this.operationManager.operate()).thenReturn(10);

    // IntegerPocket ip = new IntegerPocket(this.operationManager); // after @InjectMocks
    int result = this.integerPocket.sum();
    assertEquals(7, result); // 10 - 3 = 7

    verify(this.operationManager, times(1)).operate();
  }

  // Part of Integration Test
  @Test
  void testCalculator() {
    Mockito.when(this.calculator.sum(3, 2)).thenReturn(20);
    // If @Mock but not @Spy, calculator.substract() will be 0
    int result = this.integerPocket.compute(3, 2);
    assertEquals(24, result); // 20 + (3 - 2) + 3 = 24
  }

  // Part of Integration Test
  @Test
  void testCalculator2() {
    Mockito.when(this.calculator.substract(3, 2)).thenReturn(50);
    // If @Mock but not @Spy, calculator.sum() will be 0
    int result = this.integerPocket.compute(3, 2);
    assertEquals(58, result); // (3 + 2) + (50) + 3 = 58
  }

  // Unit Test
  @Test
  void testCalculator3() {
    Mockito.when(this.calculator.sum(3, 2)).thenReturn(99);
    Mockito.when(this.calculator.substract(3, 2)).thenReturn(1);
    int result = this.integerPocket.compute(3, 2);
    assertEquals(103, result); // 99 + 1 + 3 = 103
  }
}
