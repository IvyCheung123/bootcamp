public class DivideByZero {
  // 1. return double
  // 2. throw ArithmeticException implicitly
  public static double divide(int x, int y) {
    return x / y;
  }

  public static int getEmpolyeeCount() {
    return 0;
  }

  public static int getDepartmentExpense() {
    return 100;
  }

  // Approach 1: method() throw unchecked exception with handling
  public static int CalculateExpensePerEmployee() {
    try {
      return getDepartmentExpense() / getEmpolyeeCount(); // bug
    } catch (ArithmeticException e) {
      return 0; // fix
    }
  }

  // Approach 2: method() throw unchecked exception without handling, the exception will be thrown back to caller
  public static int CalculateExpensePerEmployee2() {
    return getDepartmentExpense() / getEmpolyeeCount(); // bug
  }

  // Approach 3: method() throw unchecked exception with handling, but throw back to caller
  public static int CalculateExpensePerEmployee3() {
    try {
      return getDepartmentExpense() / getEmpolyeeCount();
    } catch (ArithmeticException e) {
      throw new EmployeeCountZeroException();
    }
  }

  public static void main(String[] args) {
    int amount = 0;
    String s = null;
    
    // Approach 1:
    if (amount != 0) {
      System.out.println(divide(10, amount));
    } else {
      System.out.println(0);
    }

    // Approach 2: Unchecked Exception (Runtime Exception) implicitly
    // System.out.println(divide(10, amount)); // java.lang.ArithmeticException: / by zero
    try { // 意外發生就離開
      // divide(10, amount);
      // lines of code ...
      System.out.println(s.charAt(2)); // java.lang.NullPointerException
    } catch (ArithmeticException e) {
      // send email notifications ...
      System.out.println("java.lang.ArithmeticException: / by " + amount);
    } catch (NullPointerException e) {
      System.out.println("java.lang.NullPointerException: " + s);
    }

    // Approach 1: method() throw unchecked exception with handling
    double expense = DivideByZero.CalculateExpensePerEmployee(); // fix in method

    // Approach 2: method() throw unchecked exception without handling, the exception will be thrown back to caller
    try {
      double expense2 = DivideByZero.CalculateExpensePerEmployee2(); // caller
    } catch (ArithmeticException e) {
      System.out.println("please check ...");
    }

    // Approach 3: method() throw unchecked exception with handling, but throw back to caller
    try {
      CalculateExpensePerEmployee3();
    } catch (EmployeeCountZeroException e) {
      // specific handling for employee count = 0 ...
    }
  }
}
