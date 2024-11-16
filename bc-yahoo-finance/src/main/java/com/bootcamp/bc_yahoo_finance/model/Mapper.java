package com.bootcamp.bc_yahoo_finance.model;

import org.springframework.stereotype.Component;
import com.bootcamp.bc_yahoo_finance.entity.StockSymbolEntity;
import com.bootcamp.bc_yahoo_finance.model.dto.StockSymbolDTO;

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
}
