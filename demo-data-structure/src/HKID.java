import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class HKID {
  private String value;

  public HKID(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public String getString() {
    return this.value;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof HKID))
      return false;
    HKID hkid = (HKID) obj;
    return Objects.equals(this.value, hkid.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static void main(String[] args) {
    // put duplicated key
    // HashMap.put(key, value) -> call key.equals() and key.hashCode()
    HashMap<HKID, Customer> customerMap = new HashMap<>();
    System.out.println(new HKID("A1234567").equals(new HKID("A1234567"))); // true
    customerMap.put(new HKID("A1234567"), new Customer(34, "John"));
    customerMap.put(new HKID("A1234567"), new Customer(34, "John"));
    customerMap.put(new HKID("H2345678"), new Customer(10, "Jenny"));
    System.out.println(customerMap); // 3 entries -> 2 entries after @Override
    // Map.put("A1234567", new Customer()); -> use String as key -> literal pool
  }
}
