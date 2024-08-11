import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class DemoLambda {
  public static void main(String[] args) {
    // Traditional
    Swimmable p = new Swimmable() {
      @Override
      public void swim() {
        System.out.println("I am swimming");
      }
    };
    p.swim(); // I am swimming
    System.out.println(p.toString()); // DemoLambda$1@7e9e5f8a

    p = new Swimmable() {
      @Override
      public void swim() {
        System.out.println("P is swimming");
      }
    };
    p.swim(); // P is swimming
    System.out.println(p.toString()); // DemoLambda$2@58644d46

    // Lambda Expression (Java 8)
    // Reason that can use "() -> implementation": interface contains one abstract method only
    Swimmable person = () -> System.out.println("I am swimming");
    person.swim(); // I am swimming
    System.out.println(person.toString()); // DemoLambda$$Lambda$1/0x000000012c000400@58644d46

    // two different object although same obj ref
    person = () -> System.out.println("Person is swimming");
    person.swim(); // Person is swimming
    System.out.println(person.toString()); // DemoLambda$$Lambda$2/0x000000012c001800@18b4aac2

    // Calculator calculator = (a, b) -> return a + b;
    Calculator sumCalculator = (a, b) -> a + b; // no need use "return"
    System.out.println(sumCalculator.calculate(1, 2)); // 3

    Calculator multiplyCalculator = (a, b) -> a * b;
    System.out.println(multiplyCalculator.calculate(1, 2)); // 2

    // 1. More than one line of implementation, need to use "return" with the implementaion block
    // 2. If there is only one parameter, no need to use (x), can simply use x
    Drivable father = x -> {
      if (x == 0)
        return false;
      return true;
    };
    System.out.println(father.drive(0)); // false
    System.out.println(father.drive(1)); // true

    List<String> strings = new LinkedList<>();
    String str = "";
    strings.add("a");
    strings.add("abc");

    // for-each
    for (String s : strings) {
      System.out.println(s); // a abc
      str += s;
    }
    System.out.println(str); // aabc
 
    // Lambda forEach
    // strings.forEach(s -> System.out.println(s);); // no need to add ";" if only one implementation
    strings.forEach(s -> System.out.println(s)); // a abc

    strings.forEach(s -> {
      if (s.length() > 1) {
        System.out.println(s); // abc
      }
      // str += s; // Local block cannot affect variable out of this block
    });

    // Function.class
    // public interface Function<T, R> {
    //   R apply(T t);
    Function<String, Integer> stringLength = s -> 3;

    Function<String, Integer> strLen = s -> s.length(); // formula
    System.out.println(strLen.apply("hello")); // 5

    Function<String, Integer> strLen2 = new StringLength();
    System.out.println(strLen2.apply("hello")); // 5

    Function<Customer, Integer> nameLength = customer -> customer.getName().length();

    Function<Customer, String> greetingMessage = customer -> {
      String message = "I am ".concat(customer.getName());
      return message;
    };
    String message = greetingMessage.apply(new Customer("John"));
    System.out.println(message); // I am John

    // public interface BiFunction<T, U, R> {
    //   R apply(T t, U u);
    BiFunction<String, String, Integer> nameLength2 = (firstname, lastname) -> firstname.length() + lastname.length();
    System.out.println(nameLength2.apply("Vincent", "Lau")); // 10

    System.out.println(getNameLength("Vincent", "Lau")); // 10

    // public interface Consumer<T> {
    //   void accept(T t);
    Consumer<Customer> printCustomerName = customer -> System.out.println(customer.getName());
    printCustomerName.accept(new Customer("Jenny")); // Jenny

    // public interface BiConsumer<T, U> {
    //   void accept(T t, U u);
    MathOperation operation = MathOperation.MULTIPLY;
    BiConsumer<Integer, Integer> calculate = null;
    switch (operation) {
      case ADD:
        calculate = (num1, num2) -> System.out.println(num1 + num2);
        break;
      case SUBTRACT:
        calculate = (num1, num2) -> System.out.println(num1 - num2);
        break;
      case MULTIPLY:
        calculate = (num1, num2) -> System.out.println(num1 * num2);
        break;
      case DIVIDE:
        calculate = (num1, num2) -> System.out.println(num1 / num2);
        break;
    }
    calculate.accept(1, 2); // 2

    BiConsumer<Integer, Integer> twoSum = (num1, num2) -> System.out.println(sum(num1, num2));
    // Consumer can only sysout, cannot return?
    twoSum.accept(1, 2); // 3

    // public interface Supplier<T> {
    //   T get();
    Supplier<Integer> randomNumber = () -> new Random().nextInt(49) + 1; // 1 - 49
    List<Integer> marksix = new LinkedList<>();
    int ball = -1;
    while (marksix.size() < 6) {
      ball = randomNumber.get();
      if (marksix.contains(ball))
        continue;
      marksix.add(ball);
    }
    System.out.println(marksix); // [40, 12, 46, 18, 37, 49]

    // public interface Predicate<T> {
    //   boolean test(T t);
    Predicate<Customer> isNameTooLong = customer -> customer.getName().length() > 5;
    System.out.println(isNameTooLong.test(new Customer("Vincent"))); // true

    // public interface BiPredicate<T, U> {
    //   boolean test(T t, U u);
    BiPredicate<String, String> isNameTooLong2 = (firstname, lastName) -> firstname.length() + lastName.length() > 10;
    System.out.println(isNameTooLong2.test("Vincent", "Lau")); // false

    // public interface UnaryOperator<T> extends Function<T, T> {
    //   static <T> UnaryOperator<T> identity() {
    //       return t -> t;
    // UnaryOperator<String> = Function<String, String>
    // Function<T, T>
    // T apply(T t);
    UnaryOperator<String> nameFormula = s -> s + "!!!";
    System.out.println(nameFormula.apply("John")); // John!!!

    // BinaryOperator<String> = BiFunction<String, String, String>
    // BiFunction<T, T, T>
    // T apply(T t, T t); ????????????
    BinaryOperator<String> nameFormula2 = (s1, s2) -> s1 + s2;
    System.out.println(nameFormula2.apply("Vincent", "Lau")); // VincentLau
  }

  public static int getNameLength(String firstname, String lastName) {
    return firstname.length() + lastName.length();
  }

  public static int sum(int x, int y) {
    return x + y;
  }
}
