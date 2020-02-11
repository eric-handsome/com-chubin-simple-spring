package com.chubin.simple.spring.factory;

import com.chubin.simple.spring.processor.BeanPostProcessor;

public interface ListableBeanFactory extends BeanFactory{
	boolean containsBeanDefinition(String beanName);
	String[] getBeanNameForType(Class<?> clazzType);
	String[] getBeanDefinitionNames();
}
