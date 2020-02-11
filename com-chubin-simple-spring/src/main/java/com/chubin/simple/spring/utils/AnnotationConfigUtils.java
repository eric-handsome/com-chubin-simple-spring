package com.chubin.simple.spring.utils;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.beans.BeanDefinitionHolder;
import com.chubin.simple.spring.beans.RootBeanDefinition;
import com.chubin.simple.spring.context.GenericApplicationContext;
import com.chubin.simple.spring.factory.DefaultListableBeanFactory;
import com.chubin.simple.spring.processor.ConfigurationClassPostProcessor;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;

public class AnnotationConfigUtils {

	public static final String CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME =
	                 "org.springframework.context.annotation.internalConfigurationAnnotationProcessor";
	
	
	public static void registerAnnotationConfigProcessors(BeanDefinitionRegistry registry){
		registerAnnotationConfigProcessors(registry,null);
	}

	private static void registerAnnotationConfigProcessors(BeanDefinitionRegistry registry, Object source) {
		DefaultListableBeanFactory beanFactory = unwrapDefaultListableBeanFactory(registry);
		 //beanFactory todo
		Set<BeanDefinitionHolder> beanDefinitions = 
				    new LinkedHashSet<BeanDefinitionHolder>();
		if(!registry.containsBeanDefinition(CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME)){
			RootBeanDefinition root = new RootBeanDefinition(ConfigurationClassPostProcessor.class);
			root.setSource(source);
			beanDefinitions.add(registerPostProcessor(registry,root,CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME));
		}
	}

	private static BeanDefinitionHolder registerPostProcessor(BeanDefinitionRegistry registry, RootBeanDefinition root,
			String beanName) {
		root.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
		registry.registerBeanDefinition(beanName,root);
		return new BeanDefinitionHolder(root, beanName);
	}

	private static DefaultListableBeanFactory unwrapDefaultListableBeanFactory(BeanDefinitionRegistry registry) {
		if(registry instanceof DefaultListableBeanFactory){
			return (DefaultListableBeanFactory)registry;
		}else if(registry instanceof GenericApplicationContext){
			return ((GenericApplicationContext)registry).getDefaultListableBeanFactory();
		}
		return null;
	}
}
