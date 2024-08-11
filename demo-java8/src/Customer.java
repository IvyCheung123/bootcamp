public class Customer {
  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Customer(Name=" + this.name + ")";
  }
}
