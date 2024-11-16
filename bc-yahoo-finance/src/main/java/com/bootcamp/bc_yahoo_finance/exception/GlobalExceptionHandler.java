package com.bootcamp.bc_yahoo_finance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(InvalidInputException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleInvalidInputException() {
    return ErrorResponse.builder()
      .code(ErrorCode.INVALID_INPUT_EXCEOTION.getCode())
      .message(ErrorCode.INVALID_INPUT_EXCEOTION.getMessage())
      .build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleRuntimeException(RuntimeException e) {
    return ErrorResponse.builder()
      .message(e.getMessage())
      .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleException(Exception e) {
    return ErrorResponse.builder()
      .message(e.getMessage())
      .build();
  }
}
