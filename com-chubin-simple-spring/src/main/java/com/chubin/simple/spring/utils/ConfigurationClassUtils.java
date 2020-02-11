package com.chubin.simple.spring.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.chubin.simple.spring.annotation.Bean;
import com.chubin.simple.spring.annotation.Component;
import com.chubin.simple.spring.annotation.Configuration;
import com.chubin.simple.spring.beans.AbstractBeanDefinition;
import com.chubin.simple.spring.beans.AnnotatedBeanDefinition;
import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.factory.ConfigurationClassPostProcessor;
import com.chubin.simple.spring.io.MetadataReader;
import com.chubin.simple.spring.metadata.AnnotationMetadata;
import com.chubin.simple.spring.metadata.MetadataReaderFactory;
import com.chubin.simple.spring.metadata.StandardAnnotationMetadata;

public class ConfigurationClassUtils {

	private static final String CONFIGURATION_CLASS_FULL = "full";
	
	private static final String CONFIGURATION_CLASS_LITE = "lite";
	
	private static final String CONFIGURATION_CLASS_ATTRIBUTE 
	                              = Conventions.getQualifiedAttributeName(ConfigurationClassPostProcessor.class,"configurationClass");
	public static boolean isFullConfigurationClass(BeanDefinition bd) {
		// TODO Auto-generated method stub
		return CONFIGURATION_CLASS_FULL.equals(bd.getAtrribute(CONFIGURATION_CLASS_ATTRIBUTE));
	}
	private static final Set<String> candidateIndicators = new HashSet<>(4);
			        
    static{
    	candidateIndicators.add(Component.class.getName());
    }
	
	public static boolean isLiteConfigurationClass(BeanDefinition bd) {
		// TODO Auto-generated method stub
		return CONFIGURATION_CLASS_FULL.equals(bd.getAtrribute(CONFIGURATION_CLASS_ATTRIBUTE));
	}

	public static boolean checkConfigurationClassCandidate(BeanDefinition bd,
			MetadataReaderFactory metadataReaderFactory) {
		String beanClassName = bd.getBeanClassName();
		if(beanClassName == null || bd.getFactoryMethodName() != null){
			return false;
		}
		AnnotationMetadata metadata;
		if(bd instanceof AnnotatedBeanDefinition 
				&& beanClassName.equals(((AnnotatedBeanDefinition)bd).getMetadata().getClassName())){
			metadata = ((AnnotatedBeanDefinition)bd).getMetadata();
		}
		else if (bd instanceof AbstractBeanDefinition && ((AbstractBeanDefinition)bd).hasBeanClass()){
			Class<?> beanClass = ((AbstractBeanDefinition)bd).getBeanClass();
			metadata = new StandardAnnotationMetadata(beanClass,true);
		}
		else{
			try{
				MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(beanClassName);
				metadata = metadataReader.getAnnotationMetadata();
			}catch(Exception e){
				return false;
			}
		}
		//拿到元数据之后 判断当前这个bd中存在的类是不是加了@Configuration注解
		//如果存在Configuration注解 spring 认为他是一个全注解
		//不用判断是否有Component ComponentScan Import ImportResource 后面会解析
		if(isFullConfigurationCandidate(metadata)){
			 bd.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_FULL);
		}
		//这个判断的意思 是怕没有加Configuration注解 却加了以下四种注解  spring也要解析
		//判断是否加了一下注解
//		candidateIndicators.add(Component.class.getName());
//		candidateIndicators.add(ComponentScan.class.getName());
//		candidateIndicators.add(Import.class.getName());
//		candidateIndicators.add(ImportResource.class.getName());
		//如果不存在 Configuration注解 spring则认为是一个部分注解类
		else if(isLiteConfigurationCandidate(metadata)){
			bd.setAttribute(CONFIGURATION_CLASS_ATTRIBUTE, CONFIGURATION_CLASS_LITE);
		}else{
			return false;
		}
		return true;
	}

	private static boolean isLiteConfigurationCandidate(AnnotationMetadata metadata) {
		if(metadata.isInterface()){
			return false;
		}
		for (String Indicator : candidateIndicators) {
			if(metadata.isAnnotated(Indicator)){
					return true;
			}
		}
		try{
			return metadata.hasAnnotatedMethods(Bean.class.getName());
		}catch(Exception e){
			return false;
		}
	}

	private static boolean isFullConfigurationCandidate(AnnotationMetadata metadata) {
		// TODO Auto-generated method stub
		return metadata.isAnnotated(Configuration.class.getName());
	}

}
