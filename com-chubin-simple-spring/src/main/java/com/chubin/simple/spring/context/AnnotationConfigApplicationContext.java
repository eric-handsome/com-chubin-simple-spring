package com.chubin.simple.spring.context;

import com.chubin.simple.spring.register.AnnotationBeanDefinnitionRegistry;
import com.chubin.simple.spring.register.AnnotationConfigRegistry;
import com.chubin.simple.spring.sacn.ClassPathBeanDefinitionScanner;

public class AnnotationConfigApplicationContext extends GenericApplicationContext implements AnnotationConfigRegistry {

	private ClassPathBeanDefinitionScanner scanner;
	private AnnotationBeanDefinnitionRegistry registry;
	
	public AnnotationConfigApplicationContext(){
		this.registry = new AnnotationBeanDefinnitionRegistry(this);
		this.scanner = new ClassPathBeanDefinitionScanner(this);
	}
	
	public AnnotationConfigApplicationContext(Class<?>... annotationClasses){
		this();
		register(annotationClasses);
		refresh();
	}
	
	private void register(Class<?>[] annotationClasses) {
		this.registry.register(annotationClasses);
	}

	public void register(Class<?> annotationClass) {
         		
	}

	public void scan(String... basePackage) {
		// TODO Auto-generated method stub
		
	}

}
