package balance;

public enum Error {
  INSUFF_BAL(-99, "Withdrawal amount > Amount balance"),
  ;
  
  private int errorCode;
  private String errorMsg;

  private Error(int errorCode, String errorMsg) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }
}
