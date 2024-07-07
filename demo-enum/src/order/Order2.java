package order;

public class Order2 {
  private OrderStatus orderStatus;
  private int paidAmount;
  private int orderAmount;

  public Order2(int orderAmount) {
    this.orderAmount = orderAmount;
    this.orderStatus = OrderStatus.ORDERED;
  }

  public void credit(int amount) {
    this.paidAmount += amount;
    // Encapsulation 封裝
    // forward the status
    if (this.isPaid() && this.orderStatus == OrderStatus.ORDERED) {
      // this.setOrderStatus(this.orderStatus.next());
      // this.setOrderStatus(OrderStatus.PAID);
      this.setToPaid();
    }
  }

  public void setToPaid() {
    this.setOrderStatus(OrderStatus.PAID);
  }

  public boolean isPaid() {
    return this.paidAmount >= this.orderAmount;
  }

  public OrderStatus getOrderStatus() {
    return this.orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public static void main(String[] args) {
    Order2 order = new Order2(100);
    // ...
    // credit card -> 50
    order.credit(50);
    System.out.println(order.isPaid()); // false

    order.credit(50);
    // OrderStatus currentStatus = order.getOrderStatus();
    // if (order.isPaid() && currentStatus == OrderStatus.ORDERED) {
    //   // forward the status
    //   order.setOrderStatus(currentStatus.next());
    // }
    System.out.println(order.getOrderStatus()); // PAID
  }
}
