package com.chubin.simple.spring.factory;

import com.chubin.simple.spring.exception.BeansException;

public interface BeanFactory {
	<T> T getBean(String beanName,Class<T> returnType) throws BeansException;
		
}
