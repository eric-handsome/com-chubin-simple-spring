package com.chubin.simple.spring.beans;

import com.chubin.simple.spring.metadata.AnnotationMetadata;

public interface AnnotatedBeanDefinition extends BeanDefinition {

	AnnotationMetadata getMetadata();
	
	
//	MethodMetadata  getFactoryMethodMetadata();
}
