package com.bootcamp.bc_yahoo_finance.service;

import java.util.List;
import com.bootcamp.bc_yahoo_finance.entity.StockPriceEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface StockPriceService {
  List<StockPriceEntity> saveAll(List<String> symbols) throws JsonMappingException, JsonProcessingException;

  void deleteAll();
}
