public class HashSetHelper<T,U> {
  private T t;
  private U u;

  public HashSetHelper() {

  }

  public HashSetHelper(T t, U u) {
    this.t = t;
    this.u = u;
  }

  public void setU(U u) {
    this.u = u;
  }

  public static void main(String[] args) {
    HashSetHelper<String, Customer> customers = new HashSetHelper<>();
    // customers.setU("abc"); // T-> String, U -> Customer
    customers.setU(new Customer(30, "Alan"));

    // T can be same as U
    HashSetHelper<String, String> strings = new HashSetHelper<>();
  }
}
