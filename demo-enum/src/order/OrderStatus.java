package order;

public enum OrderStatus {
  ORDERED(0),
  PAID(1),
  READY_TO_SHIP(2),
  DELIVERED(3),
  ;

  private final int value;

  private OrderStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

  public OrderStatus next() {
    for (OrderStatus status : OrderStatus.values()) {
      if (this.value + 1 == status.getValue()) {
        return status;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(OrderStatus.READY_TO_SHIP.next()); // DELIVERED
  }
}
