package com.chubin.simple.spring.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.context.ConfigurableApplicationContext;
import com.chubin.simple.spring.exception.BeanDefinitionStoreException;
import com.chubin.simple.spring.exception.BeansException;
import com.chubin.simple.spring.exception.NoSuchBeanDefinitionException;
import com.chubin.simple.spring.processor.BeanPostProcessor;
import com.chubin.simple.spring.register.BeanDefinitionRegistry;
import com.chubin.simple.spring.utils.StringUtils;

public class DefaultListableBeanFactory implements ConfigurableListableBeanFactory,BeanDefinitionRegistry {

	Map<String,BeanDefinition> beanDefinitionMap 
	              = new ConcurrentHashMap<String,BeanDefinition>();
	
	List<String> beanDefinitionNames = new ArrayList<String>(256);
	
	private volatile String[] frozenBeanDefinitionNames;
	
	public boolean containsBeanDefinition(String beanName) {
		// TODO Auto-generated method stub
		return false;
	}

	public ConfigurableApplicationContext getBeanFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefintion) {
		
		BeanDefinition oldBeanDefinition = this.beanDefinitionMap.get(beanName);
		if(!Objects.isNull(oldBeanDefinition)){
			throw new BeanDefinitionStoreException("beanName 已经存在 bd 不能再次放入容器中");
		}
		synchronized(this.beanDefinitionMap){
			this.beanDefinitionMap.put(beanName, beanDefintion);
			beanDefinitionNames.add(beanName);
		}
	}

	@Override
	public String[] getBeanNameForType(Class<?> clazzType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getBeanDefinitionNames() {
		String[] frozenNames = this.frozenBeanDefinitionNames;
		if(frozenNames != null){
			frozenNames.clone();
		}else{
			return StringUtils.toStringArray(this.beanDefinitionNames);
		}
		return null;
	}

	@Override
	public <T> T getBean(String beanName, Class<T> returnType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) {
		BeanDefinition bd = this.beanDefinitionMap.get(beanName);
		if(Objects.isNull(bd)){
			throw new NoSuchBeanDefinitionException(beanName);
		}
		
		return bd;
	}
	
}
