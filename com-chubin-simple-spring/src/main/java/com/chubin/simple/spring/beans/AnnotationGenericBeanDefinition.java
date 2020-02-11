package com.chubin.simple.spring.beans;

import com.chubin.simple.spring.metadata.AnnotationMetadata;
import com.chubin.simple.spring.metadata.StandardAnnotationMetadata;

public class AnnotationGenericBeanDefinition extends GenericBeanDefinition implements AnnotatedBeanDefinition {

	private final AnnotationMetadata metadata;
	
	public AnnotationGenericBeanDefinition(Class<?> beanClass) {
		setBeanClass(beanClass);
		metadata = new StandardAnnotationMetadata();
	}

	@Override
	public String getBeanClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getAtrribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] attributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotationMetadata getMetadata() {
		// TODO Auto-generated method stub
		return this.metadata;
	}

}
