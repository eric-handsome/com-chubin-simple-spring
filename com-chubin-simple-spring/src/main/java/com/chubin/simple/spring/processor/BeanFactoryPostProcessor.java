package com.chubin.simple.spring.processor;

import com.chubin.simple.spring.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

	void postProcessBeanDefinition(ConfigurableListableBeanFactory beanFactory);
}
