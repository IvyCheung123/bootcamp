package com.bootcamp.bc_yahoo_finance.exception;

public class InvalidInputException extends NumberFormatException {
  private String code;

  public InvalidInputException(ErrorCode errorCode) {
    this(errorCode.getCode(), errorCode.getMessage());
  }

  private InvalidInputException(String code, String message) {
    super(message);
    this.code = code;
  }
}
