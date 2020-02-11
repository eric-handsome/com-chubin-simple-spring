package com.chubin.simple.spring.processor;

import com.chubin.simple.spring.exception.BeansException;

public class ConfigurationClassPostProcessor implements BeanPostProcessor {
   @Override
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
	return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
}
}
