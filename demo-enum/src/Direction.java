public enum Direction {
  EAST(1),
  SOUTH(2),
  WEST(-1),
  NORTH(-2),
  ;

  // Enum Adv:
  // 3. Able to present some relationship among the enum objects

  private final int value;

  private Direction(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public boolean isOpposite(Direction direction) {
    return this.value == direction.getValue() * -1;
  }

  public static boolean isOpposite(Direction d1, Direction d2) {
    return d1.getValue() == d2.getValue() * -1;
  }

  public Direction opposite() {
    for (Direction d : Direction.values()) {
      if (d.getValue() == this.getValue() * -1) {
        return d;
      }
    }
    return null;
  }

  public static Direction opposite(Direction direction) {
    for (Direction d : Direction.values()) {
      if (d.getValue() == direction.getValue() * -1) {
        return d;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    // Direction -> enum class
    // Direction.EAST -> object

    // Instance method
    System.out.println(Direction.EAST.isOpposite(Direction.EAST)); // false
    System.out.println(Direction.EAST.isOpposite(Direction.WEST)); // true
    System.out.println(Direction.EAST.opposite()); // WEST

    // Static method
    System.out.println(Direction.isOpposite(Direction.EAST, Direction.EAST)); // false
    System.out.println(Direction.isOpposite(Direction.EAST, Direction.WEST)); // true
    System.out.println(Direction.opposite(Direction.EAST)); // WEST
  }
}
