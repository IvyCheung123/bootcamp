package com.bootcamp.bc_yahoo_finance.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_yahoo_finance.entity.StockPriceEntity;
import com.bootcamp.bc_yahoo_finance.entity.StockSymbolEntity;
import com.bootcamp.bc_yahoo_finance.infra.yahoofinance.YHRestClient;
import com.bootcamp.bc_yahoo_finance.model.Mapper;
import com.bootcamp.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import com.bootcamp.bc_yahoo_finance.repository.StockPriceRepository;
import com.bootcamp.bc_yahoo_finance.repository.StockSymbolRepository;
import com.bootcamp.bc_yahoo_finance.service.StockPriceService;
import com.bootcamp.bc_yahoo_finance.service.StockSymbolService;
import com.bootcamp.bc_yahoo_finance.util.TranType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class StockPriceServiceImpl implements StockPriceService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private Mapper mapper;

  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Override
  public List<StockPriceEntity> saveAll(List<String> symbols) throws JsonMappingException, JsonProcessingException {
    YahooQuoteDTO yahooQuoteDTO = new YHRestClient(this.restTemplate).getQuote(symbols);
    List<YahooQuoteDTO.QuoteBody.Result> results = yahooQuoteDTO.getBody().getResult();
    List<StockSymbolEntity> stockSymbolEntities = this.stockSymbolService.findAll();

    List<StockPriceEntity> stockPriceEntities = results.stream()
      .map(sp -> {
        StockPriceEntity stockPriceEntity = this.mapper.map(sp);
        stockPriceEntity.setType(TranType.FIVE_MINUTES.getType());

        stockSymbolEntities.forEach(ss -> {
          if (ss.getSymbol().equals(stockPriceEntity.getSymbol())) {
            stockPriceEntity.setStockSymbol(ss);
          }
        });
        return stockPriceEntity;
      }).collect(Collectors.toList());

    return this.stockPriceRepository.saveAll(stockPriceEntities);
  }

  @Override
  public void deleteAll() {
    this.stockPriceRepository.deleteAll();
  }
}
