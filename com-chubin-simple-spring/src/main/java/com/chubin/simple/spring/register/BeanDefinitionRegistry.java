package com.chubin.simple.spring.register;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.context.GenericApplicationContext;

public interface BeanDefinitionRegistry  {

	boolean containsBeanDefinition(String beanName);

	void registerBeanDefinition(String beanName, BeanDefinition beanDefintion);

	String[] getBeanDefinitionNames();

	BeanDefinition getBeanDefinition(String beanName);

	//GenericApplicationContext getDefaultListableBeanFactory();
}
