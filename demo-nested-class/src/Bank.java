import java.util.LinkedList;
import java.util.List;

public class Bank {
  public List<Account> accounts;
  private String address;

  public Bank() {
    this.accounts = new LinkedList<>();
  }

  private static void creditAccount(double amount) {
    new Account().credit(amount);
  }

  public void add(Account account) {
    accounts.add(account);
  }

  public static class Account {
    private static int number = 0;
    private int accountNo;
    private double balance;

    public Account() {
      this.accountNo = ++number;
    }

    public int getAccountNo() {
      return this.accountNo;
    }

    public void credit(double amount) {
      this.balance += amount;
    }

    public void print() {
      // this.address; // Cannot access the outer class instance variable by this
      // Inner.class does not extends Outer.class
    }

    // public String getAddress() {
    //   return address; // Cannot make a static reference to the non-static field address
    // }
  }

  public static void main(String[] args) {
    Bank bank = new Bank();
    Bank.Account account = new Bank.Account();
  }
}
