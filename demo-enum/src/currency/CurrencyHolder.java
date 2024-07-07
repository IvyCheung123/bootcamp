package currency;

public class CurrencyHolder {
  private final String currency;
  private final int DBValue;

  public CurrencyHolder(String currency, int DBValue) {
    this.currency = currency;
    this.DBValue = DBValue;
  }

  public String getCurrency() {
    return this.currency;
  }

  public boolean isHKD() {
    return "HKD".equals(this.currency);
  }

  public static boolean isHKD(CurrencyHolder currency) {
    return "HKD".equals(currency.getCurrency());
  }

  // Solution: use Enum as parameters (Type-safe: Compile-time check)
  public static boolean isHKD_enum(Currency currency) {
    return "HKD".equals(currency.name());
  }

  public static void main(String[] args) {
    // 1. Cannot gurantee there is ONLY one HKD in memory
    CurrencyHolder ch1 = new CurrencyHolder("HKD", 1);
    CurrencyHolder ch2 = new CurrencyHolder("HKD", 1);

    // 2. String is not a good idea to represent a parameter that with finite numbers of object
    System.out.println(ch1.isHKD()); // true
    // It is ok, but ...
    System.out.println(CurrencyHolder.isHKD(new CurrencyHolder("HKD", 1))); // true
    System.out.println(CurrencyHolder.isHKD(new CurrencyHolder("HKD ", 1))); // false, typo mistake
    System.out.println(CurrencyHolder.isHKD(new CurrencyHolder("hkd", 1))); // false, case sensitive

    // Solution: Enum (only can put Enum into the method)
    System.out.println(isHKD_enum(Currency.HKD)); // true
  }
}
