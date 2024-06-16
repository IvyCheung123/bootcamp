package cat;

public class Cat { // Class name -> Name Convention -> able to describe physical object
  // status
  // attributes
  private String name; // definition
  private int age; // definition

  // behavior
  // instance method
  // setAge is a method that can be called by Object only
  public void setAge(int age) { // (int age) -> describe input parameter
    this.age = age;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
  
  public int getAge() {
    return this.age;
  }
}
