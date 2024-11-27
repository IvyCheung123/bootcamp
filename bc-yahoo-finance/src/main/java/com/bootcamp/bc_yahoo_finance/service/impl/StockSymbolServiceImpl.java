package com.bootcamp.bc_yahoo_finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.bc_yahoo_finance.entity.StockSymbolEntity;
import com.bootcamp.bc_yahoo_finance.repository.StockSymbolRepository;
import com.bootcamp.bc_yahoo_finance.service.StockSymbolService;

@Service
public class StockSymbolServiceImpl implements StockSymbolService {
  @Autowired
  private StockSymbolRepository stockSymbolRepository;

  @Override
  public List<StockSymbolEntity> saveAll(List<StockSymbolEntity> stockSymbolEntities) {
    return this.stockSymbolRepository.saveAll(stockSymbolEntities);
  }

  @Override
  public void deleteAll() {
    this.stockSymbolRepository.deleteAll();
  }

  @Override
  public List<StockSymbolEntity> findAll() {
    return this.stockSymbolRepository.findAll();
  }
}
