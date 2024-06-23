import java.util.Objects;

public class PersonInHk {

  private String hkid;
  private String name;

  public PersonInHk(String hkid, String name) {
    this.hkid = hkid;
    this.name = name;
  }

  // hashCode is an int value to represent if two persons are same person (with same hkid)
  @Override
  public int hashCode() {
    return Objects.hash(this.hkid);
  }

  public static void main(String[] args) {
    PersonInHk p1 = new PersonInHk("1", "John");
    PersonInHk p2 = new PersonInHk("2", "John");
    PersonInHk p3 = new PersonInHk("2", "John");
    System.out.println(p1.hashCode()); // 80
    System.out.println(p2.hashCode()); // 81
    System.out.println(p3.hashCode()); // 81
  }
}
