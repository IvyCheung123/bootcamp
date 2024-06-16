package demo;

import java.time.LocalDate;
import java.time.Month;

public class demoDate {
  public static void main(String[] args) {
    // 17 types primitives + 8 wrapper classes + String
    LocalDate ld = LocalDate.of(2022, 12, 31); // .of() similar to valueOf
    System.out.println(ld); // 2022-12-31

    // LocalDate ld2 = LocalDate.of(2022, 12, 32); // java.time.DateTimeException: Invalid value for DayOfMonth (valid values 1 - 28/31): 32
    System.out.println(ld.plusDays(1L)); // 2023-01-01, int -> long (upcast)
    System.out.println(ld.plusMonths(3L)); // 2023-03-31
    System.out.println(ld.minusYears(2L)); // 2020-12-31
    System.out.println(ld.minusWeeks(1L)); // 2022-12-24

    Month month = ld.getMonth();
    System.out.println(month.toString()); // DECEMBER, Month

    System.out.println(ld.getMonth()); // DECEMBER, Month
    System.out.println(ld.getYear()); // 2022, int
    System.out.println(ld.getDayOfMonth()); // 31, int
    System.out.println(ld.getDayOfYear()); // 365, int
    System.out.println(ld.getDayOfWeek()); // SATURDAY, DayOfWeek
  }
}
