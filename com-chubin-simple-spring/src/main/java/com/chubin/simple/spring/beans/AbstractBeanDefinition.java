package com.chubin.simple.spring.beans;

public abstract class AbstractBeanDefinition extends BeanMetadataAttributeAccessor implements BeanDefinition {

	private volatile Object beanClass;
	
	private int role  = BeanDefinition.ROLE_APPLICATION;
	
	String factoryMethodName ; 
	
	public AbstractBeanDefinition(BeanDefinition original) {
		setBeanClassName(original.getBeanClassName());
	}

	public AbstractBeanDefinition() {
		this(null);
	}

	private void setBeanClassName(String beanClassName) {
		this.beanClass = beanClassName;
		
	}

	public void setBeanClass(Class<?> beanClass){
		this.beanClass = beanClass;
	}
	
	public void setRole(int role){
		this.role = role;
	}
	
	public Class<?> getBeanClass(){
		return (Class<?>)this.beanClass;
	}
	
	@Override
	public String getFactoryMethodName() {
		// TODO Auto-generated method stub
		return this.factoryMethodName;
	}

	public boolean hasBeanClass() {
		// TODO Auto-generated method stub
		return (this.beanClass instanceof Class);
	}
}
