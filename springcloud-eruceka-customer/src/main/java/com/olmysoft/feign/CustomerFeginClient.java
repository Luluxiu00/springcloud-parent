package com.olmysoft.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "producer", fallback = CustomerFeginClientFallback.class)  
public interface CustomerFeginClient {  
  
    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)  
    String getOrder();  
  
} 