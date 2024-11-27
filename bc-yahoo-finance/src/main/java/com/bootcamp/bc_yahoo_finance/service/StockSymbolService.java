package com.bootcamp.bc_yahoo_finance.service;

import java.util.List;
import com.bootcamp.bc_yahoo_finance.entity.StockSymbolEntity;

public interface StockSymbolService {
  List<StockSymbolEntity> saveAll(List<StockSymbolEntity> stockSymbolEntities);

  void deleteAll();

  List<StockSymbolEntity> findAll();
}
