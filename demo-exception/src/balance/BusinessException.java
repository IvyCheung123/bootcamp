package balance;

public class BusinessException extends Exception {
  private int code;

  public BusinessException() {
    
  }

  // imply this is checked exception
  // public BusinessException(int errorCode, String message) {
  //   super(message); // Exception.getMessage()
  //   this.errorCode = errorCode;
  // }

  public BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.code = errorCode.getCode();
  }

  public int getCode() {
    return this.code;
  }

  public String getCodeWithMessage() {
    return "Error " + this.code + ": " + this.getMessage();
  }
}
