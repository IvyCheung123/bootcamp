package com.bootcamp.bc_yahoo_finance.model.line;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class Candle {
  private double open;
  private double close;
  private double high;
  private double low;
}
