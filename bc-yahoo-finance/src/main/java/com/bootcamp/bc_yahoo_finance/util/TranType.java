package com.bootcamp.bc_yahoo_finance.util;

public enum TranType {
  FIVE_MINUTES("5_Minutes"),
  DAILY("Daily"),
  WEEKLY("Weekly"),
  MONTHLY("Monthly"),
  ;

  private String type;

  private TranType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
}
