package form;

public class Address {
  private String line1;
  private String line2;
  private String line3;

  public Address(String line1, String line2, String line3) {
    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine1() {
    return this.line1;
  }

  public String getLine2() {
    return this.line2;
  }

  public String getLine3() {
    return this.line3;
  }

  public String toString() {
    return this.line1 + ", "+ this.line2 + ", " + this.line3;
  }

  public static void main(String[] args) {
    // Create a Form object, with Address object
    Address a1 = new Address("Diamond Hill", "Kowloon", "Hong Kong");
    Form f1 = new Form("Alan", "Chan", a1);
    System.out.println(f1.toString());
    System.out.println(f1.getAddress());

    Form f2 = new Form("Amy", "Chan", a1);
    System.out.println(f2.toString());
    System.out.println(f2.getAddress().getLine1()); // Diamond Hill

    // Both f1 and f2 move out to WTS
    f1.getAddress().setLine1("WTS");
    System.out.println(f1.getAddress().getLine1()); // WTS
    System.out.println(f2.getAddress().getLine1()); // WTS

    // Only f1 move out to Diamond Hill
    Address a2 = new Address("Diamond Hill", "Kowloon", "Hong Kong");
    f1.setAddress(a2);
    System.out.println(f1.toString()); // Name: Alan Chan; Address: Diamond Hill, Kowloon, Hong Kong
    System.out.println(f2.toString()); // Name: Amy Chan; Address: WTS, Kowloon, Hong Kong
  }
}
