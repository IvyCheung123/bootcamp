package com.bootcamp.demo;

// !!! "static import" is for static method call
// After "static import", you can call the static method by the method name directly, without calling Class.method(), i.e. Assertions.method()
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AppTest {
    @DisplayName("New Sum Test")
    @ParameterizedTest
    @CsvSource({"3, 1, 2", "0, 0, 0", "-9, -11, 2"}) // 3 test cases
    void testSumNew(int expected, int x, int y) {
        Assertions.assertEquals(expected, App.sum(x, y));
    }

    @DisplayName("Sum Test")
    @Test
    void testSum() {
        // assertEquals(6, App.sum(3, 2)); // mvn test -> error
        assertEquals(5, App.sum(3, 2));
        assertEquals(-2, App.sum(-2, 0));
        assertEquals(0, App.sum(0, 0));
        assertEquals(-5, App.sum(-2, -3));
        assertEquals(12, App.sum(10, 2));
        // test overflow ...

        // assertNotEquals(6, App.sum(3, 2));
    }

    @Test
    void testSubtract() {
        assertEquals(5, App.subtract(7, 2));
        assertEquals(-5, App.subtract(-7, -2));
        assertEquals(0, App.subtract(0, 0));
        assertEquals(8, App.subtract(10, 2));
    }

    // Unit Test
    // if (x >= 10 && y >=3)
    //     return subtract(x, y);
    // return sum(x, y);
    @Test
    void testCombine() {
        // Scenario 1: x >= 10 && y >= 3
        assertEquals(7, App.combine(10, 3));
        // Scenario 2: x < 10 && y >= 3
        assertEquals(12, App.combine(9, 3));
        // Scenario 3: x >= 10 && y < 3
        assertEquals(12, App.combine(10, 2));
        // Scenario 4: x < 10 && y < 3
        assertEquals(11, App.combine(9, 2));
        // Only 4 test cases are enough
        // For testing, it doesn't care the result of sum() and subtract()
    }

    @Test
    void testAssert() {
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = s1;
        assertNotSame(s1, s2);
        assertSame(s1, s3);

        String s4 = null;
        assertNull(s4);
        assertNotNull(s3);
    }

    @Test
    void testThrow() {
        assertThrows(ArithmeticException.class, () -> {
            App.divide(10, 0);
        });

        // !!! Common used
        assertDoesNotThrow(() -> {
            App.divide(10, 1);
        });
    }

    @Test
    void testArray() {
        int[] arr = new int[] {1, 2, 3};
        int[] arr2 = new int[] {1, 2, 3};
        assertArrayEquals(arr, arr2); // check both ordering & element

        // int[] arr3 = new int[] {2, 1, 3};
        // assertArrayEquals(arr, arr3); // No assertArrayNotEquals()
    }

    @Test
    void testAssertAll() {
        assertAll(
            () -> assertTrue(App.sum(3, 2) == 5),
            () -> assertEquals(8, App.subtract(10, 2))
        ); // correct if all lines are correct
    }

    // Non-functional Requirement
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // Normally, you write the logic to test ...
            Thread.sleep(90);
            // Thread.sleep(110);
        });
    }
}
