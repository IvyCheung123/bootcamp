public class demoConditional {
  public static void main(String[] args) throws Exception {
    // Conditional: if
    int x = 3;
    if (x >= 3) {
      System.out.println("x >= 3");
    }
    int y = 2;
    if (y >= 3) {
      System.out.println("y is greater or equal to 2");
    } else {
      System.out.println("y is not greater or equal to 2");
    }

    int a = 10;
    int b = 11;
    // print max=10
    // if...
    if (a > b) {
      System.out.println("max="+a);
    } else {
      System.out.println("max="+b);
    }
  }
}
