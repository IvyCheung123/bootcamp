public class Book1 {
  private double price;
  private String author;

  public Book1(double price, String author) {
    this.price = price;
    this.author = author;
  }

  // Type of instance method
  // 1. getter, setter
  // 2. presentation -> defintion
  public boolean isTooExpensive() {
    return this.price > 100;
  }

  // Transform:
  // 1. replace -> return self
  // NO: substring -> new String

  public static void main(String[] args) {
    Book book = new Book(99, "John");
    System.out.println(book.price()); // 99.0
    System.out.println(book.getPrice()); // 99.0
    // System.out.println(book.price); // private

    Book book2 = new Book(99, "John");
    System.out.println(book.equals(book2)); // true
    System.out.println(book.hashCode()); // -891121365
    System.out.println(book2.hashCode()); // -891121365
    System.out.println(book.toString()); // Book[price=99.0, author=John]
  }
}
