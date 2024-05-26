public class demoLoop2 {
  public static void main(String[] args) {
    // no "continue" condition -> no "exit" condition -> infinite loop
    /* for (int i = 0; ; i++) {
      System.out.println(i);
    }
    for ( ; ; ) { System.out.println("hello"); }
    */
    
    // Label: outerLoop -> labeled start point for "continue"
    outerLoop: for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) {
          continue outerLoop; // skip to the next iteration of the outer loop
        }
        System.out.println("i: " + i + ", j: " + j);
      }
    }
  }
}
// control + c to stop