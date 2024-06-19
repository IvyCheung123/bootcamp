public abstract class Person { // abstract 抽象
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public static void main(String[] args) {
    // abstract class cannot create object
    // Person p = new Person("Alan", 13);

    // 1. Student.class is public
    // 2. Student.class constructor is public
    Student s = new Student(1, "Alan", 13);
  }
}
