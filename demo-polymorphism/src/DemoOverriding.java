public class DemoOverriding { // dynamic polymorphism (run-time)
  
  public static void main(String[] args) {
    // Example 1:
    Animal2 cat = new Cat2();
    cat.walk(); // CatTwo is walking ...
    // Compile time check the scope of the object, but not the implementation
    // cat.run(); // Compile error, AnimalTwo.class has walk() only

    // During run-time, the new cat object is created in heap memory
    // then object reference animalTwo1 will point to the cat object
    // and execute CatTwo.walk() method

    // Example 2:
    Animal2 animal = new Animal2();
    animal.walk(); // AnimalTwo is walking ...
    // No relationship with CatTwo.class

    // Example 3:
    Animal2 dog = new Dog2();
    // dog.sleep(); // Compile error
    Dog2 dog2 = (Dog2) dog;
    dog2.sleep(); // DogTwo is sleeping ...
  }
}
