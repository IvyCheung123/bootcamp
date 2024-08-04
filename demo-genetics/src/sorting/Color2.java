package sorting;

public enum Color2 {
  RED(1),
  WHITE(2),
  BLACK(3),
  ;

  private int value;

  private Color2(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
