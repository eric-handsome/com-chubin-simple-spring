package com.chubin.simple.spring.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class StandardAnnotationMetadata extends StandardClassMetadata implements AnnotationMetadata {

	private final Class<?> introspectedClass = null;
	
	private final Annotation[] annotations;
	private final boolean nestedAnnotationAsMap;
	

	public StandardAnnotationMetadata(Class<?> beanClass, boolean b) {
		super(beanClass);
		this.annotations = introspectedClass.getAnnotations();
		this.nestedAnnotationAsMap = b;
	}

	public String getClassName() {
		return this.introspectedClass.getName();
	}

	@Override
	public boolean isAnnotated(String annotationName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInterface() {
		// TODO Auto-generated method stub
		return this.introspectedClass.isInterface();
	}

	@Override
	public boolean hasAnnotatedMethods(String annotationName) {
		Method[] declaredMethods = getIntrospectedClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			if(!method.isBridge() && method.getAnnotations().length>0){
				return true;
			}
		}
		return false;
	}

	public  final Class<?> getIntrospectedClass() {
		// TODO Auto-generated method stub
		return this.introspectedClass;
	}
}
