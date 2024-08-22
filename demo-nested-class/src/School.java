public class School {
  public static void createSubject() {

    // Method Local Inner Class (really not common)
    class Subject {
      private String subject;

      public Subject(String subject) {
        this.subject = subject;
      }

      public String getSubject() {
        return this.subject;
      }
    }

    Subject ict = new Subject("ICT");
    System.out.println(ict.getSubject());
  }

  public static void main(String[] args) {
    // Subject.class can be only used by createSubject() method
    // Subject s = new Subject("ICT");
    School.createSubject(); // ICT
  }
}
