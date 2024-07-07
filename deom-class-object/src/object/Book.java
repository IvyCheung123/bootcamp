package object;

import java.time.LocalDate;

public class Book {
  private String name;
  private LocalDate publishDate;
  private int price;

  // Instance method (Object method)
  public void setName(String name) {
    this.name = name;
  }
  // Instance method (Object method)
  public void setPublishDate(LocalDate publishDate) {
    this.publishDate = publishDate;
  }
  // Instance method (Object method)
  public void setPrice(int price) {
    this.price = price;
  }
  /*
  // Instance method (Object method)
  public String getName() {
    return this.name;
  }
  // Instance method (Object method)
  public LocalDate getPublishDate() {
    return this.publishDate;
  }
  // Instance method (Object method)
  public int getPrice() {
    return this.price;
  }
  */
  // Static method -> produce sth by the input parameter
  // Static method should not access any object attributes
  public static String hello() {
    return "hello";
  }

  public String describe() {
    return " Name: " + this.name + ",  Publish Date: " + this.publishDate + ",  Price: $" + this.price + ".";
  }
  // Static method
  public static void main(String[] args) {
    Book b1 = new Book ();
    Book b2 = new Book ();
    Book b3 = new Book ();

    b1.setName("Java Beginner 1");
    b1.setPublishDate(LocalDate.of(2023, 01, 01));
    b1.setPrice(100);

    b2.setName("Java Beginner 2");
    b2.setPublishDate(LocalDate.of(2024, 02, 02));
    b2.setPrice(200);

    b3.setName("Java Beginner 3");
    b3.setPublishDate(LocalDate.of(2024, 06, 04));
    b3.setPrice(300);

    // Static method belongs to Class
    System.out.println(Book.hello());

    System.out.println(b1.describe());
    System.out.println(b2.describe());
    System.out.println(b3.describe());
  }
}
