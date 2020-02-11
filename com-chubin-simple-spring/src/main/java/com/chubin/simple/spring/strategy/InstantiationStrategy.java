package com.chubin.simple.spring.strategy;

import com.chubin.simple.spring.beans.RootBeanDefinition;
import com.chubin.simple.spring.factory.BeanFactory;

public interface InstantiationStrategy {

	
	Object instantiate(RootBeanDefinition bd ,String beanName,BeanFactory owner);
	
}
