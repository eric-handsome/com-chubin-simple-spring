package com.chubin.simple.spring.metadata;

public interface AnnotationMetadata extends ClassMetadata {

	public boolean isAnnotated(String annotationName);

	public boolean isInterface();

	public boolean hasAnnotatedMethods(String annotationName);
}
