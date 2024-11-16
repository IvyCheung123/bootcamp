package com.bootcamp.bc_yahoo_finance.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_yahoo_finance.infra.yahoofinance.CookieManager;
import com.bootcamp.bc_yahoo_finance.infra.yahoofinance.CrumbManager;
import com.bootcamp.bc_yahoo_finance.infra.yahoofinance.YHRestClient;
import com.bootcamp.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {
  @Autowired
  private RestTemplate restTemplate;

  // @GetMapping("/test")
  // public String test() {
  //   return new CookieManager(restTemplate).getCookie();
  // }

  // @GetMapping("/test")
  // public String test() {
  //   return new CrumbManager(restTemplate).getCrumb();
  // }

  @GetMapping("/test")
  public YahooQuoteDTO test() throws JsonMappingException, JsonProcessingException{
    return new YHRestClient(this.restTemplate).getQuote(List.of("0388.HK,0700.HK"));
  }
}
