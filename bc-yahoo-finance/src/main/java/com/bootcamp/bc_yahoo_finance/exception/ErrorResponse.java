package com.bootcamp.bc_yahoo_finance.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ErrorResponse {
  private String code;
  private String message;
}
