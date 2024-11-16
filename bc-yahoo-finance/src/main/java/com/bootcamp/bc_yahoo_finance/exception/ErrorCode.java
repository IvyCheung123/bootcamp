package com.bootcamp.bc_yahoo_finance.exception;

public enum ErrorCode {
  INVALID_INPUT_EXCEOTION("100001", "Invalid input"),
  STOCK_ID_NOT_FOUND_EXCEPTION("100002", "Stock id not found"),
  ;

  private String code;
  private String message;

  private ErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
