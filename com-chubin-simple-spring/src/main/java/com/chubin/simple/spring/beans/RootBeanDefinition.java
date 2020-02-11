package com.chubin.simple.spring.beans;

public class RootBeanDefinition extends AbstractBeanDefinition{

	public RootBeanDefinition(Class<?> beanClass){
		super();
		setBeanClass(beanClass);
	}
	
	public RootBeanDefinition(BeanDefinition original) {
		super(original);
	}

	@Override
	public String getBeanClassName() {
		// TODO Auto-generated method stub
		return null;
	}
}
