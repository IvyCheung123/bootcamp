package com.bootcamp.bc_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bootcamp.bc_yahoo_finance.redis.RedisHelper;
import com.bootcamp.bc_yahoo_finance.service.StockPriceService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class AppSchedular {
  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private StockPriceService stockPriceService;

  /**
   * 1. Every minute
   * @Scheduled(cron = "0 * * * * ?")
   * 2. Once per day at midnight
   * @Scheduled(cron = "0 0 0 * * ?")
   * 3. Once per week on Sunday at midnight
   * @Scheduled(cron = "0 0 0 ? * SUN")
   * 4. Run only on weekdays at 09:00
   * @Scheduled(cron = "0 0 9 ? * MON-FRI")
   * 5. Run on the last day of every month at 23:59
   * @Scheduled(cron = "0 59 23 L * ?")
   * 6. Run on the first day of every month at 12:00
   * @Scheduled(cron = "0 0 0 1 * ?")
   */

  @Scheduled(cron = "0 0/5 9-16 * * MON-FRI")
  public void cronJob() throws JsonProcessingException {
    String[] arr = this.redisHelper.get("STOCK-LIST", String[].class);

    List<String> symbols = Arrays.stream(arr)
      .collect(Collectors.toList());
    
    this.stockPriceService.saveAll(symbols);
    System.out.println("5-Minutes Cron Job saved successfully.");
  }
}
