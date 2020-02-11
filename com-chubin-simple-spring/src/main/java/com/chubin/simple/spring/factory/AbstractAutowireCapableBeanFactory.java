package com.chubin.simple.spring.factory;

import com.chubin.simple.spring.beans.RootBeanDefinition;
import com.chubin.simple.spring.strategy.InstantiationStrategy;
import com.chubin.simple.spring.wrapper.BeanWrapper;
import com.chubin.simple.spring.wrapper.BeanWrapperImpl;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	private InstantiationStrategy instantiationStrategy;
	
	protected Object createBean(String beanName, RootBeanDefinition mbd, Object[] args) {
		// TODO Auto-generated method stub
		return doCreateBean(beanName, mbd, args);
	}

	protected Object doCreateBean(String beanName, RootBeanDefinition mbd, Object[] args) {
		BeanWrapper instanceWrapper = null;
		instanceWrapper = createBeanInstance(beanName, mbd, args);
		return null;
	}

	protected BeanWrapper createBeanInstance(String beanName, RootBeanDefinition mbd, Object[] args) {
			
		return instantiateBean(beanName,mbd);
	}

	protected BeanWrapper instantiateBean(String beanName, RootBeanDefinition mbd) {
		Object object;
		object = getInstantiationStrategy().instantiate(mbd,beanName,null);
		BeanWrapper bw = new BeanWrapperImpl(object);
		return null;
	}	

	private InstantiationStrategy getInstantiationStrategy() {
		// TODO Auto-generated method stub
		return this.instantiationStrategy;
	}
}
