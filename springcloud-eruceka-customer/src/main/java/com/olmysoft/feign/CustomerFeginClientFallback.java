package com.olmysoft.feign;

import org.springframework.stereotype.Component;

@Component
public class CustomerFeginClientFallback implements CustomerFeginClient {

	@Override
	public String getOrder() {
		return "出错了111!!!";
	}

}
