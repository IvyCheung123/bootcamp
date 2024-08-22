public record Book(double price, String author) {
  public static final double MIN_PRICE = 5.0d;
  // public final double MIN = 1.0d;

  public static double calculateFinalPrice(double price, double discount) {
    return price * (1 - discount);
  }

  public boolean isTooExpensive() {
    return this.price > 100;
  }

  public double getPrice() {
    return this.price;
  }

  // public void serPrice(double price) {
  //   this.price = price;
  // }

  public static void main(String[] args) {
    Book book = new Book(99, "John");
    System.out.println(book.price()); // getter, 99.0
    // no setter
    System.out.println(book.price); // 99.0

    // 1. default getter -> price(), author()
    // . NO default setter
    // 2. only one default constructor (all args constructor)
    // 3. attributes are private final
    // 4. already support equals(), hashCode(), toString()
    // 5. class is final (cannot be extended)
    // 6. Support custom static and instance method
    // 7. Support static final, static attribute
    // 8. NOT support custom final instance variable
    // 9. NOT support custom setter and constructor (but support custom getter)
  }
}
