public class Student extends Person {
  private int studentId;
  // private String name;
  // private int age;

  // Constructor -> the process of constructing student object
  public Student(int studentId, String name, int age) {
    // Person = parent class, Student = child class
    // calling parent class constructor
    // 1. create Person inside Student Object (heap object)
    super(name, age);
    this.studentId = studentId;
  }

  /*
  public Student(String name, int studentId, int age) {
    this.studentId = studentId;
    this.name = name;
    this.age = age;
  }
  */
  /*
  public String getName() {
    return this.name;
  }
  */

  public int getStudentId() {
    return this.studentId;
  }

  // 做多咗
  public void setAge(int age) {
    // 2. call parent setAge() method
    super.setAge(age);
  }
  /*
  public int getAge() {
    return this.age;
  }
  */

  public static void main(String[] args) {
    // 1. Person.class is public
    // 2. Person.class constructor is public
    // Person p = new Person("Alan", 13);

    Student s = new Student(1, "Alan", 13); // Student Object in heap memory
    System.out.println(s.getStudentId()); // 1
    System.out.println(s.getName()); // Alan
    System.out.println(s.getAge()); // 13
  }
}
