package com.chubin.simple.spring.factory;

import com.chubin.simple.spring.processor.BeanPostProcessor;

public interface ConfigurableBeanFactory extends BeanFactory {
	void setBeanClassLoader(ClassLoader classLoader);
	void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
