package com.bootcamp.bc_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.bc_yahoo_finance.entity.StockSymbolEntity;
import com.bootcamp.bc_yahoo_finance.model.Mapper;
import com.bootcamp.bc_yahoo_finance.redis.RedisHelper;
import com.bootcamp.bc_yahoo_finance.service.StockSymbolService;

@Configuration
public class AppRunner implements CommandLineRunner {
  @Autowired
  private StockSymbolService stockSymbolService;

  @Autowired
  private Mapper mapper;

  @Autowired
  private RedisHelper redisHelper;

  @Override
  public void run(String... args) throws Exception {
    this.stockSymbolService.deleteAll();

    System.out.println("Starting server ...");

    String[] symbols = new String[] {"0388.HK", "0700.HK", "0005.HK"};

    List<StockSymbolEntity> stockSymbolEntity = Arrays.stream(symbols)
      .map(s -> this.mapper.map(s))
      .collect(Collectors.toList());

    this.stockSymbolService.saveAll(stockSymbolEntity);

    // Redis
    this.redisHelper.set("STOCK-LIST", symbols);
    System.out.println("Saving stock symbols to Redis ...");
  }
}