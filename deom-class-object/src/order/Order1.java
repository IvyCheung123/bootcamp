package order;

import java.math.BigDecimal;
import java.util.Arrays;

public class Order1 {

  // static variable (belongs to class)
  public static String prefix = "Order";
  private static int count = 0;
  // private variable (belongs to object)
  private int id;
  private Item[] items;
  private String coupon;

  // All Argument Constructor
  public Order1(String prefix) {
    this.id = ++count;
    this.items = new Item[0];
  }

  // Setter
  public void setCoupon() {
    this.coupon = "hasCoupon";
  }

  public void addItem(Item item) {
    Item[] itemList = new Item[this.items.length + 1];
    for (int i = 0; i < this.items.length; i++) {
      itemList[i] = this.items[i];
    }
    itemList[itemList.length - 1] = item;
    this.items = itemList;
  }

  // Getter
  public int getId() {
    return this.id;
  }

  public Item[] getItems() {
    return this.items;
  }

  public String getCoupon() {
    return this.coupon;
  }
  
  public boolean isCouponValid() {
    boolean isCouponValid = false;
    if (this.coupon == "hasCoupon") {
      isCouponValid = true;
    }
    return isCouponValid;
  }

  public double getDiscount() {
    if (isCouponValid() == true) {
      return 0.2d;
    } else {
      return 0.0d;
    }
  }

  public double orderTotal() {
    BigDecimal amount = BigDecimal.valueOf(0L);
    // BigDecimal add, subtract, multiply, divide methods return itself -> new object address
    for (int i = 0; i < this.items.length; i++) {
      // amount.add(BigDecimal.valueOf(this.items[i].subtotal())); -> return new BigDecimal()
      amount = amount.add(BigDecimal.valueOf(this.items[i].itemSubtotal()));
    }
    amount = amount.multiply(BigDecimal.valueOf(1.0 - getDiscount()));
    return amount.doubleValue();
  }

  public String getOrderTotal() {
    return Order1.prefix + " " + this.getId() + " (Order Total: $" + this.orderTotal() + ")";
  }

  // toString()
  public String toString() {
    return Order1.prefix + " " + this.getId() + " " + Arrays.toString(this.items);
  }

  public static void main(String[] args) {

    Order1 order1 = new Order1(prefix);
    Item item1 = new Item("AAA", 96.0d, 2);
    System.out.println(item1.getItemSubtotal()); // 192.0
    order1.addItem(item1);

    Item item2 = new Item("BBB", 10.0d, 3);
    System.out.println(item2.getItemSubtotal()); // 30.0
    order1.addItem(item2);

    System.out.println(order1.toString());
    System.out.println(order1.getOrderTotal()); // 192.0 + 30.0 = 222.0
    
    Order1 order2 = new Order1(prefix);
    Item item3 = new Item("CCC", 5.5, 5);
    System.out.println(item3.getItemSubtotal()); // 27.5
    order2.addItem(item3);

    Item item4 = new Item("DDD", 32.8, 1);
    System.out.println(item4.getItemSubtotal()); // 32.8
    order2.addItem(item4);

    order2.setCoupon(); // hasCoupon
    System.out.println(order2.toString());
    System.out.println(order2.getOrderTotal()); // (27.5 + 32.8) * (1.0 - 0.2) = 48.24

  }

}
