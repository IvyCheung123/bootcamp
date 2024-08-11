package balance;

public class Account {
  private double balance;

  public Account() {
    this.balance = 0.0d;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void credit(double amount) {
    this.balance += amount;
  }

  public void debit(double amount) throws InsufficientBalance {
    if (this.balance < amount)
      // throw new IllegalArgumentException(); // Unchecked exception
      // throw new BusinessException(ErrorCode.INSUFF_BAL); // Checked exception
      throw new InsufficientBalance();
    this.balance -= amount;
  }

  public static void main(String[] args) {
    // main() throws InsufficientBalance -> JVM -> 照爆
    Account ac = new Account();
    ac.credit(100);
    // ac.debit(101);
    // java.lang.IllegalArgumentException // Unchecked exception
    // Unhandled exception type InsufficientBalance // Checked exception

    try {
      ac.debit(50);
      ac.debit(51); // exception
    } catch (BusinessException e) {
      System.out.println(e.getCodeWithMessage()); // Error -99: Withdrawal amount > Amount balance
    } finally {
      // Run no matter there is an exception or not
    }
    System.out.println(ac.getBalance()); // 50.0
  }
}
