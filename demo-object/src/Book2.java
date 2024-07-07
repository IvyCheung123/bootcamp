// public class Book extends Object {}

import java.time.LocalDate;
import java.util.Objects;

public class Book2 { // implicitly inherit Object.class
  
  private String author;
  private LocalDate publishDate;

  public Book2(String author, LocalDate publishDate) {
    this.author = author;
    this.publishDate = publishDate;
  }

  public String getAuthor() {
    return this.author;
  }

  public LocalDate getPublishDate() {
    return this.publishDate;
  }

  // if you do not @Override, the hashCode() method by default representing the object address
  @Override
  public int hashCode() {
    return Objects.hash(this.author, this.publishDate);
  }

  // make it become true even if they are different object in heap memory
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Book2)) { // instanceof -> checking if the object pointing by reference is an object produced by BookTwo.class
      return false;
    }
    Book2 book = (Book2) obj;
    // if (book.getAuthor().equals(this.author) 
    //     && (book.getPublishDate().compareTo(this.publishDate) == 0)) {
    //       return true;
    // }
    // return false;
    return Objects.equals(this.author, book.getAuthor())
        && Objects.equals(this.publishDate, book.getPublishDate());
  }

  public static void main(String[] args) {
    Book2 b1 = new Book2("John", LocalDate.of(2000, 12, 12));
    Book2 b2 = new Book2("John", LocalDate.of(2000, 12, 12));
    Book2 b3 = new Book2("John", LocalDate.of(2000, 12, 13));

    System.out.println(b1.hashCode()); // 75848450
    System.out.println(b2.hashCode()); // 75848450
    System.out.println(b3.hashCode()); // 75848451

    System.out.println(b1 == b2); // false, two new object
    System.out.println(System.identityHashCode(b1)); // 1933863327
    System.out.println(System.identityHashCode(b2)); // 112810359

    // Object.class has equals() method
    // if you do not override, equals() by default checking the object address
    // System.out.println(b1.equals(b2)); // false, before override

    System.out.println(b1.equals(b2)); // true, after override
    System.out.println(b1.equals(b3)); // false, after override

    char chr = 'a';
    int asciiChar = chr;
    System.out.println(asciiChar); // 97

    String str = "abc";
    System.out.println(str.hashCode()); // 96354
    System.out.println(97 * (int) Math.pow(31, 2) + 98 * 31 + 99); // 96354

    // Implication
    // there will be another string value with same hashCode
    String str2 = "1234567890";
    System.out.println(str2.hashCode()); // -2054162789

    String str3 = "01234567890";
    System.out.println(str3.hashCode()); // 1886485195, overflow

    Integer i = 365;
    System.out.println(i.hashCode()); // 365

    System.out.println(new String("abc").equals(new String("abc"))); // true
    System.out.println(new String("abc") == (new String("abc"))); // false

    String s1 = new String("abc");
    String s2 = new String("abc");
    System.out.println(s1.equals(s2)); // true

    Object s3 = new String("abc");
    Object s4 = new String("abc");
    System.out.println(s3.equals(s4)); // true (runtime), calling String.equals()
    // Object is a class, runtime 係搵隻object自己身上嘅method, 隻object嘅type係String
    // Object s3 - BookTwo.main(String[]) -> polymorphism
    System.out.println(s3.hashCode()); // 96354, but int java.lang.Object.hashCode()
    // Compile time determine if s3 is able to call equals()
    // Run time determine the implementation (method content) of equals() method
    Object s5 = new Object();
    Object s6 = new Object();
    System.out.println(s5.equals(s6)); // false, calling Object.equals()
  }
}
