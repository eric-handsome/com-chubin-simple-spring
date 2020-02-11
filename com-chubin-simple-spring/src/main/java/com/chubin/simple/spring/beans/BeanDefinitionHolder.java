package com.chubin.simple.spring.beans;

public class BeanDefinitionHolder {
    private final BeanDefinition beanDefintion;
    private final String beanName;
    
    public BeanDefinitionHolder(BeanDefinition beanDefintion,String beanName){
    	this.beanDefintion = beanDefintion;
    	this.beanName = beanName;
    }

	public String getBeanName() {
		return beanName;
	}

	public BeanDefinition getBeanDefintion() {
		return beanDefintion;
	}
    
    
}
