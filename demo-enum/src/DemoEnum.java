public class DemoEnum {

  // Constant (finite)
  public static final String MONDAY_STRING = new String("Monday");
  public static final String TUESDAY_STRING = "Tuesday";
  public static final String WEDNESDAY_STRING = "Wednesday";
  public static final String THURSDAY_STRING = "Thursday";
  public static final String FRIDAY_STRING = "Friday";

  public static final String directionEast = "East";

  public static void main(String[] args) {
    System.out.println(DemoEnum.MONDAY_STRING); // Monday

    // What happen in heap memory?
    // Answer: static variable will not point to object

    // Before the main method being executed, it loads enum class
    System.out.println(Weekday.MONDAY); // MONDAY, calling Weekday MONDAY toString()

    // Other examples?

    // EAST, SOUTH, WEST, NORTH
    String directionEast = "East";
    if (directionEast.equals("East")) {
      
    }

    Direction east = Direction.EAST;
    if (east == Direction.EAST) { // compare object address directly

    }
  }

}
