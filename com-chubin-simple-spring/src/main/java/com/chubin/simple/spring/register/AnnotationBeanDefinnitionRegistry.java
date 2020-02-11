package com.chubin.simple.spring.register;

import com.chubin.simple.spring.beans.AnnotationGenericBeanDefinition;
import com.chubin.simple.spring.beans.BeanDefinitionHolder;
import com.chubin.simple.spring.utils.AnnotationConfigUtils;
import com.chubin.simple.spring.utils.BeanDefinitionReaderUtils;

public class AnnotationBeanDefinnitionRegistry {
	
    private final BeanDefinitionRegistry registry;
	
	public AnnotationBeanDefinnitionRegistry(BeanDefinitionRegistry registry) {
		this.registry = registry;
		AnnotationConfigUtils.registerAnnotationConfigProcessors(registry);
	}

	public void register(Class<?>[] annotationClasses) {
		for (Class<?> annotationClass : annotationClasses) {
			registerBean(annotationClass);
		}
	}

	private void registerBean(Class<?> annotationClass) {
		 doRegisterBean(annotationClass,null,null,null);
	}

	private void doRegisterBean(Class<?> annotationClass, Object object, Object object2, Object object3) {
		AnnotationGenericBeanDefinition abd = new AnnotationGenericBeanDefinition(annotationClass);
		//自定义生成 beanName
		String beanName = 
				 annotationClass.getSimpleName().substring(0,1).toUpperCase()+annotationClass.getSimpleName().substring(0);
	    BeanDefinitionHolder bdHolder = new BeanDefinitionHolder(abd, beanName);
	    BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder,this.registry);
	}
}
