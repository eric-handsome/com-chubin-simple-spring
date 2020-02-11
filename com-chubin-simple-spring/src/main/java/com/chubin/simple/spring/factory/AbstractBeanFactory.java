package com.chubin.simple.spring.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.chubin.simple.spring.beans.BeanDefinition;
import com.chubin.simple.spring.beans.RootBeanDefinition;
import com.chubin.simple.spring.exception.BeansException;
import com.chubin.simple.spring.support.FactoryBeanRegistrySupport;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

	private final Map<String, RootBeanDefinition> mergedBeanDefinition = new ConcurrentHashMap<>(256);

	@Override
	public <T> T getBean(String beanName, Class<T> returnType) throws BeansException {
		// TODO Auto-generated method stub
		return doGetBean(beanName, returnType,null);
	}

	private <T>T doGetBean(String beanName, Class<T> returnType,Object[] args) {
		Object bean;
		Object sharedInstance = getSingleton(beanName);
		if(sharedInstance !=null){
			bean = getObjectForBeanInstance(sharedInstance,beanName);
		}else {
			final RootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName);
			sharedInstance = getSingleton(beanName,() -> {
				try{
					return createBean(beanName,mbd,args);
				}catch(BeansException bx){
				}
				return mbd;
			});
		}
		
		return null;
	}

	abstract Object createBean(String beanName, RootBeanDefinition mbd, Object[] args);
		 

	private RootBeanDefinition getMergedLocalBeanDefinition(String beanName) {
		RootBeanDefinition mbd = mergedBeanDefinition.get(beanName);
		if (mbd != null) {
			return mbd;
		}
		return getMergedBeanDefinition(beanName, getBeanDefinition(beanName));
	}

	private RootBeanDefinition getMergedBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		//todo
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(beanDefinition);
		return rootBeanDefinition;
	}

	private Object getObjectForBeanInstance(Object sharedInstance, String beanName) {
		// TODO Auto-generated method stub
		return sharedInstance;
	}

	public String[] getBeanDefinitionNames(){
		return getBeanFactroy().getBeanDefinitionNames();
	}
	
	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
 
	protected abstract ConfigurableListableBeanFactory getBeanFactroy();

}
