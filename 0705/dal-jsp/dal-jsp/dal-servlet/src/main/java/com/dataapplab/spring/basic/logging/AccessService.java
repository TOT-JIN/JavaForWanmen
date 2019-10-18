package com.dataapplab.spring.basic.logging;

import org.springframework.stereotype.Component;

import com.dataapplab.spring.basic.logging.annotation.Logging;

@Component
public class AccessService{
	@Logging
	public void tryException()  {
		int[] outIndex = {1,2,3};
		
		int a = outIndex[4];
	}

}
