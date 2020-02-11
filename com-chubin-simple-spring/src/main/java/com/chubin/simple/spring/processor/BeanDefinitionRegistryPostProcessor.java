package com.chubin.simple.spring.processor;

import com.chubin.simple.spring.exception.BeansException;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;

public interface BeanDefinitionRegistryPostProcessor  extends BeanFactoryPostProcessor{

	void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;
}
