public class Person {
    private String name;
    private int age;
    // attribute x n ...

    // Builder pattern should not contain any public constructor
    public Person() {

    }

    // private Person(String name, int age) {
    //     this.name = name;
    //     this.age = age;
    // }

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    // Adv 1: No need to create all constructor pattern for attribute x n
    // public Person(String name) {
    //     this.name = name;
    // }

    // public Person(int age) {
    //     this.age = age;
    // }

    public static Builder builder() {
        return new Person.Builder();
    }

    public void setName(String name) {
        this.name = name;
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

    public static class Builder {
        private String name;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        // public Person build() {
        //     return new Person(this.name, this.age);
        // }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        // Traditional
        Person person = new Person();
        person.setName("John");
        person.setAge(18);

        // Builder Pattern
        // Adv 2: More easier to create new object with attribute x n
        Person person2 = Person.builder() // create new Builder object
            .name("John") // return current Builder object
            .age(18) // return current Builder object
            .build(); // create Person object
        System.out.println(person2.getName() + ", " + person2.getAge()); // John, 18
    }
}
