package currency;

public enum Currency {
  // Enum Adv: see CurrencyHolder & Direction

  HKD("Hong Kong Dollar", 1), // similar to new Currency("Hong Kong Dollar")
  USD("United States Dollar", 2),
  JPY("Japanese Yen", 3),
  ;

  // Instance variable
  private final String description;
  private final int DBValue;

  // Constructor
  private Currency(String description, int DBValue) {
    this.description = description;
    this.DBValue = DBValue;
  }

  // Getter
  public String getDescription() {
    return this.description;
  }

  public int getDBValue() {
    return this.DBValue;
  }

  // 2 -> USD, 3 -> JPY
  public static Currency get(int DBValue) {
    for (Currency c : Currency.values()) {
      if (DBValue == c.getDBValue()) {
        return c;
      }
    }
    return null;
  }

  // HKD -> 1, USD -> 2
  public static int get(Currency currency) {
    return currency.getDBValue();
  }

  public static String fullDescription(Currency currency) {
    // if (currency == Currency.HKD) {
    //   return "HK$";
    // } else if (currency == Currency.USD) {
    //   return "US$";
    // } else if (currency == Currency.JPY) {
    //   return "JP¥";
    // }
    // return null;

    // Switch + Enum -> Perfect Match
    switch (currency) {
      case HKD:
        return "HK$"; // no need to break, return = quit method, not quit switch
      case USD:
        return "US$";
      case JPY:
        return "JP¥";
      default:
        return null;
    }
  }

  public static void main(String[] args) {
    Currency currency = Currency.HKD;
    if (currency == Currency.HKD) {
      System.out.println("It is " + currency.getDescription() + ".");
    } else if (currency == Currency.USD) {
      System.out.println("It is " + currency.getDescription() + ".");
    } else if (currency == Currency.JPY) {
      System.err.println("It is " + currency.getDescription() + ".");
    }

    System.out.println(currency); // HKD
    System.out.println(currency.toString()); // HKD, already @Override to return name

    // default instance methods provided by ENUM.class
    // 1. name()
    System.out.println(currency.name()); // HKD

    // 2. values() -> use for-each to loop the array ENUM.values()
    for (Currency c : Currency.values()) {
      System.out.println(c.getDescription());
    }
    // Hong Kong Dollar
    // United States Dollar
    // Japanese Yen

    System.out.println(Currency.values().length); // 3

    // 3. hashCode() -> MUST unique
    System.out.println(Currency.HKD.hashCode()); // 205029188
    System.out.println(Currency.USD.hashCode()); // 1309552426

    // 4. equals() -> compare address?
    System.out.println(Currency.HKD.equals(currency)); // true
    System.out.println(Currency.USD.equals(currency)); // false

    // Operator (&&): if 前面 is false, will not execute 後面
    System.out.println(currency != null && currency.equals(Currency.HKD));

    String str = "abc"; // String str = null;
    // NOT OK
    if (str.equals("abc")) { // potentially null pointer exception

    }
    // OK
    if ("abc".equals(str)) { // true or false

    }

    System.out.println(Currency.get(1)); // HKD, calling toString()

    // 5. valueOf(), static method: String -> Enum
    System.out.println(Currency.valueOf("HKD").name()); // "HKD" -> Currency enum -> name() -> HKD
    // System.out.println(Currency.valueOf("123").name()); // run-time error, java.lang.IllegalArgumentException: No enum constant Currency.123

    System.out.println(Currency.fullDescription(Currency.JPY)); // JP¥
  }
}
