package com.bootcamp.bc_yahoo_finance.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_yahoo_finance.infra.yahoofinance.CookieManager;
import com.bootcamp.bc_yahoo_finance.infra.yahoofinance.CrumbManager;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CookieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/getcookie")
  public String getCookie() {
    return new CookieManager(restTemplate).getCookie();
  }

  @GetMapping("/getcrumb")
  public String getCrumb() {
    return new CrumbManager(restTemplate).getCrumb();
  }
}
