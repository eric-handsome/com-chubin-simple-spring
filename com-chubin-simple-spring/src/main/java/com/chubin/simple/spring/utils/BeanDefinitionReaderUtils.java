package com.chubin.simple.spring.utils;

import com.chubin.simple.spring.beans.BeanDefinitionHolder;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;

public class BeanDefinitionReaderUtils {

	public static void registerBeanDefinition(BeanDefinitionHolder bdHolder, BeanDefinitionRegistry registry) {
		String beanName = bdHolder.getBeanName();
		//向IOC容器注册BeanDefinition
		registry.registerBeanDefinition(beanName,bdHolder.getBeanDefintion());
	}

}
