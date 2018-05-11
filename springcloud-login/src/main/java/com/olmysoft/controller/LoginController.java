package com.olmysoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olmysoft.entity.User;
import com.olmysoft.service.ILoginService;

import io.swagger.annotations.ApiOperation;
import redis.clients.jedis.JedisCluster;

@RestController
public class LoginController {

	
	@Autowired
	private JedisCluster jc;
	@Autowired
	private ILoginService loginService;
	
	
	@ApiOperation(value="获取redis信息",notes="无入参，直接调用getOrder即可获取用户信息")
	@RequestMapping(value="/getRedisValue",method=RequestMethod.GET)
    @ResponseBody  
    public String getRedisValue() {  
  
        return jc.get("hello");  
    }
	
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.GET)
	@ResponseBody
	public String login() {
		
		
		return loginService.getUser().getUsername();
	}
}
