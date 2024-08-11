package balance;

public class InsufficientBalance extends BusinessException {
  public InsufficientBalance() {
    super(ErrorCode.INSUFF_BAL);
  }
}
