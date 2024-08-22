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

  public BusinessException(Error error) {
    super(error.getErrorMsg());
    this.code = error.getErrorCode();
  }

  public int getCode() {
    return this.code;
  }

  public String getCodeWithMsg() {
    return "Error " + this.code + ": " + this.getMessage();
  }
}
