package com.chubin.simple.spring.beans;

import com.chubin.simple.spring.accessor.AttributeAccessor;

public interface BeanDefinition extends AttributeAccessor {
	int ROLE_APPLICATION = 0;
	int ROLE_INFRASTRUCTURE = 2;
	
	String getBeanClassName();

	String getFactoryMethodName();

}
