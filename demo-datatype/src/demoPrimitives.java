public class demoPrimitives {
  public static void main(String[] args) {
    // number
    // int is a data type that declaring the type of value of x can be stored.
    int x = 3;
    // int y = 0.5; // y cannot store non-integer number
    // + - * / %
    int a = 3;
    int sum = x + a;
    int subtract = x - a;
    int multiply = x * a;
    int divide = x / a;
    System.out.println(sum);
    System.out.println(subtract);
    System.out.println(multiply);
    System.out.println(divide);
    int remainder = 7 % 2;
    System.out.println(remainder);

    // 2024.05.10
    // Primitive: double
    double d1 = 0.5;
    double d2 = -10.555;
    double d3 = 10.555;
    double dd = d1 + d2 + d3;
    System.out.println(dd);
    // double + - * / will have issue in some scanario
    double dd2 = 0.1 + 0.2;
    System.out.println(dd2); // 0.30000000000000004
    // int f1 = 7;
    // double f2 = 8.8;
    // int f3 = f1 + f2;
    // error -> Type mismatch: cannot convert from double to int
    // int is lower level than double in java
    // int + double -> double (7.0) + double (8.8) -> double (15.8)
    // int g = 10 / 3 ;
    // int / int -> int -> 3, so 3 can be assigned to variable g

    // Primitive: char (use single quote to declare a char value)
    char c1 = '!';
    char c2 = ' ';
    char c3 = 'A';
    // char c4 = ''; // error -> nothing
    // char c5 = 'aa'; // error -> single character
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);

    // Primitive: boolen
    boolean z1 = true;
    boolean z2 = false;
    System.out.println(z1);
    System.out.println(z2);

    // Primitive for Integer
    // int, long, byte, short
    byte b1 = -128; // -128 to 127 (2^x)
    byte b2 = 127;
    System.out.println(b1 + b2);
    // byte b3 = 128; // compile error -> java can identify the syntax error
    short s1 = -32768; // -32768 to 32767
    short s2 = 32767;
    System.out.println(s1 + s2);
    int i1 = -2147483648; // -2147483648 to 2147483647
    int i2 = 2147483647;
    System.out.println(i1 + i2);
    long l1 = -9223372036854775808L; // -9223372036854775808 to 9223372036854775807
    long l2 = 9223372036854775807L;
    System.out.println(l1 + l2);
    // L means a way to specify this value is a long value, not a int value
    
    // Primitive for number with decimal
    // You cannot assign a double value to a float variable
    // float is a lower level of data type than double
    double d5 = 10.5;
    float f5 = 10.5f;
    System.out.println("double 10.5 = " + d5);
    System.out.println("float 10.5f = " + f5);
    // float f6 = 10.5f + 10.5; // error
    // float + double -> double, cannot assign double to float
    float f7 = 10.5f + 10L; // float + long -> float
    System.out.println(f7);
    double d7 = 99.99d; // same as double double6 = 99.99;
    System.out.println("double 99.99d = " + d7);

    // Local Variable (within main() program, you can only declare the same variable once)
    double d8; // variable declaration
    d8 = 8; // value assignment
    double d9 = 9; // declaration and assignment
    d9 = 99; // reassignment
    System.out.println("double 8 = " + d8 + ", double 9 -> 99 = " + d9);

    // In conclude, higher level of data type cannot assign to lower level of data type
    // boolean < byte < short < char < int < long < float < double
    // Can upgrade: byte -> short -> int -> long -> float -> double
  }
}
