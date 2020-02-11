package com.chubin.simple.spring.delegate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.factory.ConfigurableListableBeanFactory;
import com.chubin.simple.spring.processor.BeanDefinitionRegistryPostProcessor;
import com.chubin.simple.spring.processor.BeanFactoryPostProcessor;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;

public class PostPcocessorRegistrationDelegate {

	public static void invokeBeanDactoryPostProcessors(ConfigurableListableBeanFactory beanFactory,
			List<BeanFactoryPostProcessor> beanFactoryPostProcessors) {
		
		Set<String> processedBeans = new HashSet<>();
		
		if(beanFactory instanceof BeanDefinitionRegistry){
			BeanDefinitionRegistry registry = (BeanDefinitionRegistry)beanFactory;
			List<BeanFactoryPostProcessor> regularPostProcessors = new LinkedList<>();
			List<BeanDefinitionRegistryPostProcessor> registryProcessors = new LinkedList<>();
			//判断自己定义的处理器
			for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessors) {
				if(beanFactoryPostProcessor instanceof BeanDefinitionRegistryPostProcessor){
					BeanDefinitionRegistryPostProcessor registryPostProcessor	=
							  (BeanDefinitionRegistryPostProcessor)beanFactoryPostProcessor;
					registryPostProcessor.postProcessBeanDefinitionRegistry(registry);
					registryProcessors.add(registryPostProcessor);
				}else{
					regularPostProcessors.add(beanFactoryPostProcessor);
				}
			}
			List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors = new ArrayList<>();
			String[] postProcessorNames = 
					 beanFactory.getBeanNameForType(BeanDefinitionRegistryPostProcessor.class);
			for (String ppName : postProcessorNames) {
				currentRegistryProcessors.add(beanFactory.getBean(ppName,BeanDefinitionRegistryPostProcessor.class));
				processedBeans.add(ppName);
			}
			registryProcessors.addAll(currentRegistryProcessors);
			
			//开始扫描 bean 放入bd中 (执行所有的BeanDefinitionRegistryPostProcessor 自定义和spring内置的都执行)
			invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors,registry);
		}
	}

	private static void invokeBeanDefinitionRegistryPostProcessors(
			List<BeanDefinitionRegistryPostProcessor> currentRegistryProcessors, BeanDefinitionRegistry registry) {
		 
		for (BeanDefinitionRegistryPostProcessor postProcessor : currentRegistryProcessors) {
			postProcessor.postProcessBeanDefinitionRegistry(registry);
		}
		
	}

}
