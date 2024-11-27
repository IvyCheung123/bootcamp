package com.bootcamp.bc_yahoo_finance.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.stereotype.Component;
import com.bootcamp.bc_yahoo_finance.entity.StockPriceEntity;
import com.bootcamp.bc_yahoo_finance.entity.StockSymbolEntity;
import com.bootcamp.bc_yahoo_finance.model.dto.StockSymbolDTO;
import com.bootcamp.bc_yahoo_finance.model.dto.YahooQuoteDTO;

@Component
public class Mapper {
  public StockSymbolEntity map(String symbol) {
    return StockSymbolEntity.builder()
      .symbol(symbol)
      .build();
  }

  public StockSymbolDTO map(StockSymbolEntity stockSymbolEntity) {
    return StockSymbolDTO.builder()
      .symbol(stockSymbolEntity.getSymbol())
      .build();
  }

  public StockPriceEntity map(YahooQuoteDTO.QuoteBody.Result result) {
    return StockPriceEntity.builder()
      .symbol(result.getSymbol())
      .regularMarketTime(result.getRegularMarketTime())
      .regularMarketPrice(result.getRegularMarketPrice())
      .regularMarketChangePercent(result.getRegularMarketChangePercent())
      .bid(result.getBid())
      .bidSize(result.getBidSize())
      .ask(result.getAsk())
      .askSize(result.getAskSize())
      .type(null)
      // .apiDatetime(LocalDateTime.now(ZoneId.of("CTT")).toString())
      .apiDatetime(LocalDateTime.now().toString())
      .marketUnixTime(result.getRegularMarketTime())
      .build();
  }
}
