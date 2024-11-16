package com.bootcamp.bc_yahoo_finance.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_yahoo_finance.redis.RedisHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/redis")
public class RedisController {
  @Autowired
  private RedisHelper redisHelper;

  @GetMapping("/get")
  public String[] get() throws JsonProcessingException {
      return this.redisHelper.get("STOCK-LIST", String[].class);
  }
}
