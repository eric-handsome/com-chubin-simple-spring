package com.chubin.simple.spring.context;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.factory.ConfigurableListableBeanFactory;
import com.chubin.simple.spring.factory.DefaultListableBeanFactory;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;

public class GenericApplicationContext extends AbstractApplicationContext implements BeanDefinitionRegistry {
    private final DefaultListableBeanFactory beanFactory = null;
	
    public final ConfigurableListableBeanFactory getDefaultListableBeanFactory(){
		return this.beanFactory;
	}

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefintion) {
		 this.beanFactory.registerBeanDefinition(beanName,beanDefintion);
	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() {
		// TODO Auto-generated method stub
		return null;
	};
}
