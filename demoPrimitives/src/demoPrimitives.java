public class demoPrimitives {
  public static void main(String[] args) {
    // number / string (text)
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

    // String stores text
    String q = "Hello", w = " World";
    System.out.println(q+w);
    String e = "I am ";
    String r = "Alan.";
    String er = e + r;
    System.out.println(er);
  }
}
