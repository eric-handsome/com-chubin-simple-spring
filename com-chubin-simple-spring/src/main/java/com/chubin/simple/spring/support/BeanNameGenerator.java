package com.chubin.simple.spring.support;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;

public interface BeanNameGenerator {

	String generateBeanName(BeanDefinition definition,BeanDefinitionRegistry registry);
}
