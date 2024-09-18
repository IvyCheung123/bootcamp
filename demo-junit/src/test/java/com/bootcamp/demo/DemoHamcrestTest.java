package com.bootcamp.demo;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// !!! assertThat
public class DemoHamcrestTest {
  @Test
  void test() {
    assertThat(App.sum(1, 2), is(equalTo(3)));
    assertThat(App.subtract(1, 2), is(equalTo(-1)));
    assertThat(App.subtract(1, 2), is(not(equalTo(-2))));

    String s = null;
    assertThat(s, is(nullValue()));
    s = "abc";
    assertThat(s, is(not(nullValue())));

    String s2 = s;
    assertThat(s, is(sameInstance(s2)));

    String s3 = "abc";
    assertThat(s, is(sameInstance(s3))); // Literal Pool

    // Comparison
    // allOf() -> all conditions passed
    assertThat(App.sum(40, 2), allOf(
      greaterThan(41),
      greaterThanOrEqualTo(42),
      lessThan(43),
      lessThanOrEqualTo(42),
      equalTo(42)
    ));

    // String
    assertThat("hello", containsString("ll"));
    assertThat("hello", not(containsString("lll")));
    assertThat("hello", endsWith("lo"));
    assertThat("hello", startsWith("h"));
    assertThat("", is(emptyString()));
  }

  @Test
  @DisplayName("List Test")
  void testList() {
    List<String> strings = List.of("abc", "def", "xyz");

    assertThat(strings, hasSize(3));

    assertThat(strings, contains("abc", "def", "xyz")); // contains() = contain all with order
    assertThat(strings, not(contains("abc", "xyz", "def")));

    assertThat(strings, containsInAnyOrder("abc", "xyz", "def"));
    assertThat(strings, not(containsInAnyOrder("abc", "xyz")));

    assertThat(strings, hasItem("def"));
    assertThat(strings, hasItems("def", "xyz"));

    assertThat(strings, is(not(empty())));
  }

  @Test
  void testArray() {
    String[] arr = new String[] {"apple", "banana", "orange"};

    assertThat(arr, arrayWithSize(3));

    assertThat(arr, arrayContaining("apple", "banana", "orange"));
    assertThat(arr, not(arrayContaining("apple", "banana")));

    assertThat(arr, arrayContainingInAnyOrder("apple", "orange", "banana"));
    assertThat(arr, not(arrayContainingInAnyOrder("apple", "orange")));

    // assertThat(arr, hasItem("apple"));
  }

  @Test
  void testPolymorphism() {
    Number number = Long.valueOf(3L);

    assertThat(number, is(instanceOf(Long.class)));
    assertThat(number, is(instanceOf(Number.class)));
    assertThat(number, is(instanceOf(Object.class)));

    assertThat(Cat.class, typeCompatibleWith(Animal.class)); // Cat.class extends Animal.class
    // assertThat(Dog.class, typeCompatibleWith(Animal.class)); // java.lang.AssertionError -> Dog.class does not extend Animal.class
  }

  public static void main(String[] args) {
    // assertEquals(args, args);
    // assertNotEquals(args, args);
    // assertSame(args, args);
    // assertNotSame(args, args);
    // assertThrows(null, null)
  }
}
