package balance;

public class InsuffBalException extends BusinessException {
  public InsuffBalException() {
    super(Error.INSUFF_BAL);
  }
}
