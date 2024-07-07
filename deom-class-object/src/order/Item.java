package order;

import java.math.BigDecimal;

public class Item {

  // Attributes
  private String itemName;
  private double price;
  private int qty;

  // Constructors
  // Empty Constructor
  public Item() {

  }
  // All Arguments Constructor
  public Item(String itemName, double price, int qty) {
    this.itemName = itemName;
    this.price = price;
    this.qty = qty;
  }

  // Setter
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  // Getter
  public String getItemName() {
    return this.itemName;
  }

  public double getPrice() {
    return this.price;
  }

  public int getQty() {
    return this.qty;
  }

  public double itemSubtotal() {
    return BigDecimal.valueOf(this.price).multiply(BigDecimal.valueOf(this.qty)).doubleValue();
  }

  public String getItemSubtotal() {
    return Order1.prefix + " (" + this.getItemName() + " Subtotal: $" + this.itemSubtotal() + ")";
  }

  // toString()
  public String toString() {
    return "Item: " + this.itemName + ", Price: $" + this.price + ", Qty: " + this.qty;
  }
}
