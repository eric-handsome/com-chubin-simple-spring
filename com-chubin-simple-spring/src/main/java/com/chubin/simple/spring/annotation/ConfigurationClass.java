package com.chubin.simple.spring.annotation;

import com.chubin.simple.spring.metadata.AnnotationMetadata;

public class ConfigurationClass {
    private final AnnotationMetadata metadata;
    private String beanName;
	
	public ConfigurationClass(AnnotationMetadata metadata,String name){
		this.metadata = metadata;
		this.beanName = name;
	}

	public AnnotationMetadata getMetadata() {
		// TODO Auto-generated method stub
		return this.getMetadata();
	}
}
