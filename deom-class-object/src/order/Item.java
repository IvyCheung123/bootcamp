package order;

import java.math.BigDecimal;

public class Item {
  private double price;
  private int qty;

  public Item(double price, int qty) {
    this.price = price;
    this.qty = qty;
  }

  public double getPrice() {
    return this.price;
  }

  public int getQty() {
    return this.qty;
  }

  public double subtotal() {
    return BigDecimal.valueOf(this.price).multiply(BigDecimal.valueOf(this.qty)).doubleValue();
  }
}
