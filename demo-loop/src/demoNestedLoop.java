public class demoNestedLoop {
  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) { // 0,1,2,3
      for (int j = 0; j < 2; j++) { // 0,1
        // 0 -> 0,1
        // 1 -> 0,1
        // 2 -> 0,1
        // 3 -> 0,1
        System.out.println("hello i = " + i + ", j = " + j);
      }
    }
    /*
     * hello i = 0, j = 0
     * hello i = 0, j = 1
     * hello i = 1, j = 0
     * hello i = 1, j = 1
     * hello i = 2, j = 0
     * hello i = 2, j = 1
     * hello i = 3, j = 0
     * hello i = 3, j = 1
     */

     System.out.println("\b");
     /*
     * hello i = 1, j = 0
     * hello i = 3, j = 0
     */

     // Approach 2:
    for (int i = 0; i < 4; i++) {
        if (i % 2 == 0) {
          continue;
        }
      for (int j = 0; j < 2; j++) {
        if (j % 2 == 1) {
          continue;
        }
        System.out.println("hello i = " + i + ", j = " + j);
      }
    }

    System.out.println("\nBelow is exercise: ");
    // Exercise
    // 1 - 20
    // 1 3 5 7 9 12 14 16 18 20
    for (int i = 0; i < 21; i++) {
      if (i <= 10 && i % 2 == 0) {
        continue;
      } else if (i > 10 && i % 2 == 1) {
        continue;
      }
      System.out.print(i + " ");
    }

    System.out.println("\b");

    // Searching
    String s = "Vincent Book Game Laptop";
    // Find the index of the first character 'a'
    // 14
    int idx = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'a') {
          idx = i;
          break; // exit loop, not if
        }
      }
      System.out.println(idx);

      // *****
      for (int i = 0; i < 5; i++) {
        System.out.print("*");
      }
      System.out.println("\n");

      // *****
      // *****
      // *****
      // *****
      // *****
      for (int row = 0; row < 5; row++) {
        for (int column = 0; column < 5; column++) {
          System.out.print("*");
        }
        System.out.println();
      }

      System.out.println();

      // *****
      // ****
      // ***
      // **
      // *
      for (int row = 0; row < 5; row++) {
        for (int column = 0; column < 5 - row; column++) {
          System.out.print("*");
        }
        System.out.println();
      }

      System.out.println();

      // *
      // **
      // ***
      // ****
      // ***
      // **
      // *
      for (int row = 1; row <= 4; row++) { // 1 2 3 4
          for (int column = 1; column <= row; column++) {
            System.out.print("*");
          }
          System.out.println();
      }
      for (int i = 3; i >= 1; i--) { // 3 2 1
        for (int j = 1; j <= i; j++) { // 1 2 3
          System.out.print("*");
        }
        System.out.println();
      }
  }
}
