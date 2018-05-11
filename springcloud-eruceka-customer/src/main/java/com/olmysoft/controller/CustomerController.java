package com.olmysoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.olmysoft.feign.CustomerFeginClient;

import io.swagger.annotations.ApiOperation;

@Controller
@EnableAutoConfiguration
public class CustomerController {

	/*@Autowired
	private RestTemplate restTemplate;*/

	@Autowired
	private CustomerFeginClient feginClient;

	private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	
	//@HystrixCommand(fallbackMethod="fallback")
	@ApiOperation(value="获取用户信息",notes="无入参，直接调用getUser即可获取用户信息")
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	@ResponseBody
	public String getUser() {

		// 调用远程服务
		/*ResponseEntity<String> responseEntity = restTemplate.getForEntity(
				"http://myproducer/getOrder", String.class);
		logger.info("res=" + JSON.toJSONString(responseEntity));*/
		
		String result = feginClient.getOrder();
		logger.info("res1111="+result);
		return result;
	}
	
	public String fallback() {
		return "error";
	}

}