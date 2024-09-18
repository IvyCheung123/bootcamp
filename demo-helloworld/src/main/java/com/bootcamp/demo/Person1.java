package com.bootcamp.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Getter // class level
@AllArgsConstructor
@NoArgsConstructor
// @ToString
// @EqualsAndHashCode
@Builder // 背後會call NoArgsConstructor, AllArgsConstructor -> if no, mvn compile will error
@Data // Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode
public class Person1 {
  private String name;

  @Setter // field level, only setAge()
  private int age;

  public static void main(String[] args) {
    Person1 p1 = new Person1();
    p1.setAge(1);
    // p1.setName("John");
    System.out.println(p1.getAge());
    System.out.println(p1.getName());
    System.out.println(p1); // toString

    Person1 p2 = new Person1("Peter", 20);
    System.out.println(p2);

    Person1 p3 = Person1.builder()
      .age(30)
      .name("May")
      .build();
  }
}
