package com.chubin.simple.spring.parser;

import java.util.Set;

import com.chubin.simple.spring.annotation.ConfigurationClass;
import com.chubin.simple.spring.beans.AbstractBeanDefinition;
import com.chubin.simple.spring.beans.AnnotatedBeanDefinition;
import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.beans.BeanDefinitionHolder;
import com.chubin.simple.spring.core.Ordered;
import com.chubin.simple.spring.env.Environment;
import com.chubin.simple.spring.io.MetadataReader;
import com.chubin.simple.spring.io.ResourceLoader;
import com.chubin.simple.spring.metadata.AnnotationMetadata;
import com.chubin.simple.spring.metadata.MetadataReaderFactory;
import com.chubin.simple.spring.metadata.StandardAnnotationMetadata;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;
import com.chubin.simple.spring.support.BeanNameGenerator;

public class ConfigurationClassParser {

	
	private MetadataReaderFactory metadataReaderFactory;
	private ProblemReporter problemReporter;
	private Environment environment;
	private ResourceLoader resourceLoader;
	private BeanDefinitionRegistry registry;

	public ConfigurationClassParser(MetadataReaderFactory metadataReaderFactory,
			ProblemReporter problemReporter, Environment environment,ResourceLoader resourceLoader,
			     BeanNameGenerator componentScanBeanNameGenerator,BeanDefinitionRegistry registry){
		
		this.metadataReaderFactory = metadataReaderFactory;
		this.problemReporter = problemReporter;
		this.environment = environment;
		this.resourceLoader = resourceLoader;
		this.registry = registry;
	}

	public void parse(Set<BeanDefinitionHolder> candidates) {
		for (BeanDefinitionHolder holder : candidates) {
			BeanDefinition bd = holder.getBeanDefintion();
			if(bd instanceof AbstractBeanDefinition){
				//判断自己定义的类是否加了@Configuration配置类
				//解析注解 （componentScan和import...）
				//解析注解对象，并且把解析出来的bd放到map，但是这里的bd指的是普通的
				//何谓不普通的呢？比如@Bean 和各种beanFactoryPostProcessor得到的bean不在这里put
				//但是是这里解析，只是不put而已
				parse(((AnnotatedBeanDefinition)bd).getMetadata(),holder.getBeanName());
			}
			
		}
	}

	private void parse(AnnotationMetadata metadata, String beanName) {
		processConfigurationClass(new ConfigurationClass(metadata,beanName));
	}

	private void processConfigurationClass(ConfigurationClass configClass) {
		SourceClass sourceClss = asSourceClass(configClass);
		sourceClss = doProcessConfigurationClass(configClass,sourceClss);
		
	}
	
	private SourceClass doProcessConfigurationClass(ConfigurationClass configClass, SourceClass sourceClss) {
		// TODO Auto-generated method stub
		return null;
	}

	private SourceClass asSourceClass(ConfigurationClass configClass) {
		AnnotationMetadata metadata = configClass.getMetadata();
		if(metadata instanceof StandardAnnotationMetadata){
			 return asSourceClass(((StandardAnnotationMetadata)metadata).getIntrospectedClass());
		}
		return asSourceClass(metadata.getClassName());
	}

	private SourceClass asSourceClass(Class<?> introspectedClass) {
		if(introspectedClass == null){
			return new SourceClass();
		}
		return new SourceClass() ;
	}

	private SourceClass asSourceClass(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	private class SourceClass implements Ordered{
        private final Object source = null;  //Class or MetadataReader
        private final AnnotationMetadata metadata = null;
		
		@Override
		public int getOrder() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
