package com.chubin.simple.spring.exception;

public class NoSuchBeanDefinitionException extends BeansException{

	
	public NoSuchBeanDefinitionException(String name) {
		super("No bean named" +name +"available");
	}
}
