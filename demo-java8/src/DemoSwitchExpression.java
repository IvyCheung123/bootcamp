public class DemoSwitchExpression {
  public static enum Color {
    RED, BLACK,WHITE;
  }

  public static void main(String[] args) {
    Color color = Color.WHITE;
    // Traditional switch -> void -> no return -> need break
    switch (color) {
      case RED:
        System.out.println("RED");
        break;
      case BLACK:
      System.out.println("BLACK");
        break;
      case WHITE:
      System.out.println("WHITE");
        break;
      // enum -> no need default -> all enum value is handled
    } // WHITE

    // Switch Expression
    // 1. return something -> no need break
    // 2. Check if all possible enum value is handled
    String result = switch (color) {
      case RED -> {
        int x = 0;
        if (x == 0)
          yield "RED";
        else
          yield "!RED";
      } // similar to return
      case BLACK, WHITE -> "BLACK | WHITE"; // one line implementation -> no need yield
    };
    System.out.println(result); // BLACK | WHITE
  }
}
