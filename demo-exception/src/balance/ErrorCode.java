package balance;

public enum ErrorCode {
  INSUFF_BAL(-99, "Withdrawal amount > Amount balance"),
  ;
  
  private int code;
  private String message;

  private ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
