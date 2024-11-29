package com.bootcamp.bc_yahoo_finance.model.line;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class PriceLine<T> {
  private Long stockId;
  private String stockSymbol;
  private LineType lineType;
  @Builder.Default
  private Set<PricePoint<T>> points;

  public PriceLine(Long stockId, String stockSymbol, LineType lineType) {
    this.stockId = stockId;
    this.stockSymbol = stockSymbol;
    this.lineType = lineType;
    this.points = new HashSet<>();
  }

  public boolean add(PricePoint<T> pricePoint) {
    return this.points.add(pricePoint);
  }

  public void clear() {
    this.points.clear();
  }

  public enum LineType {
    MIN1,
    MIN5,
    MIN15,
    MIN30,
    HOUR1,
    HOUR4,
    DAY,
    WEEK,
    MONTH,
    ;
  }

  public static void main(String[] args) {
    PriceLine<Candle> candleList = new PriceLine<>(1L, "0700.HK", LineType.MIN5);

    candleList.add(new PricePoint<Candle>(LocalDateTime.of(
      LocalDate.now(), LocalTime.now()), new Candle(456.78, 456.78, 456.78, 456.78)));
    
    System.out.println(candleList);
  }
}
