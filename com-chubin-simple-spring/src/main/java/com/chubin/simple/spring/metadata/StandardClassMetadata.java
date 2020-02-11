package com.chubin.simple.spring.metadata;

public class StandardClassMetadata implements ClassMetadata {
    private final Class<?> introspectedClass; 
	
	
	public StandardClassMetadata(Class<?> beanClass) {
		this.introspectedClass = beanClass;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return null;
	}

}
