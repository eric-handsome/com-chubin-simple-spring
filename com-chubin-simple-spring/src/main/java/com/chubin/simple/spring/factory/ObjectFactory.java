package com.chubin.simple.spring.factory;

import com.chubin.simple.spring.exception.BeansException;

public interface ObjectFactory<T> {

	T getObject() throws BeansException;
	
}
