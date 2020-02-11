package com.chubin.simple.spring.register;

public interface AnnotationConfigRegistry {
	void register(Class<?> annotationClass);
	void scan(String... basePackage);
}
