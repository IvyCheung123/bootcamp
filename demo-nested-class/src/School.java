public class School {
  public static void createSubject() {

    // Method Local Inner Class (really not common)
    class Subject {
      
    }

    Subject subject = new Subject();

  }

  public static void main(String[] args) {
    // Subject.class can be only used by createSubject() method
  }
}
