package com.chubin.simple.spring.factory;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.beans.BeanDefinitionHolder;
import com.chubin.simple.spring.env.Environment;
import com.chubin.simple.spring.exception.BeansException;
import com.chubin.simple.spring.io.ResourceLoader;
import com.chubin.simple.spring.metadata.CachingMetadataReaderFactory;
import com.chubin.simple.spring.metadata.MetadataReaderFactory;
import com.chubin.simple.spring.parser.ConfigurationClassParser;
import com.chubin.simple.spring.parser.ProblemReporter;
import com.chubin.simple.spring.processor.BeanDefinitionRegistryPostProcessor;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;
import com.chubin.simple.spring.utils.ConfigurationClassUtils;

public class ConfigurationClassPostProcessor implements BeanDefinitionRegistryPostProcessor {
	  //  Logge
	private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
	
	private ProblemReporter problemReporter;
	
	private Environment environment;
	
	private ResourceLoader resourceLoader;
	@Override
	public void postProcessBeanDefinition(ConfigurableListableBeanFactory beanFactory) {
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		processConfigBeanDefinitions(registry);
	}

	private void processConfigBeanDefinitions(BeanDefinitionRegistry registry) {
		//定义一个List存放app 提供的bd(项目当中提供了@Component)
		List<BeanDefinitionHolder> configCandidates = new ArrayList<>();
		String[] candidateNames = registry.getBeanDefinitionNames();
		
		for (String beanName : candidateNames) {
			BeanDefinition bd = registry.getBeanDefinition(beanName);
			if(ConfigurationClassUtils.isFullConfigurationClass(bd)||
					ConfigurationClassUtils.isLiteConfigurationClass(bd)){
			}
			else if( ConfigurationClassUtils.checkConfigurationClassCandidate(bd,this.metadataReaderFactory)){
				
				configCandidates.add(new BeanDefinitionHolder(bd, beanName));
			}
		}
		
		if(configCandidates.isEmpty()){
			return;
		}
		
		ConfigurationClassParser parser = new ConfigurationClassParser(this.metadataReaderFactory,
				           this.problemReporter,this.environment,this.resourceLoader,null,registry);
		Set<BeanDefinitionHolder> candidates = new LinkedHashSet<>(configCandidates);
	    parser.parse(candidates);
	
	}

}
