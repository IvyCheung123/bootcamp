package com.bootcamp.bc_yahoo_finance.entity;

import java.io.Serializable;
import com.bootcamp.bc_yahoo_finance.util.TranType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TSTOCKS_PRICE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"stock_id", "symbol", "regularMarketTime", "regularMarketPrice", "regularMarketChangePercent", "bid", "bidSize", "ask", "askSize", "type", "apiDatetime", "marketUnixTime", "stockSymbol"})
public class StockPriceEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "stock_id")
  @JsonProperty("stock_id")
  private Long id;
  private String symbol;
  private Long regularMarketTime;
  private Double regularMarketPrice;
  private Double regularMarketChangePercent;
  private Double bid;
  private Long bidSize;
  private Double ask;
  private Long askSize;
  private String type; // 5M = 5 Minutes, D = Daily, W = Weekly, M = Monthly
  private String apiDatetime;
  private Long marketUnixTime;

  @ManyToOne
  @JoinColumn(name = "stock_id")
  @JsonIgnore
  private StockSymbolEntity stockSymbol;
}