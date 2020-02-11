package com.chubin.simple.spring.strategy;

import java.lang.reflect.Constructor;

import com.chubin.simple.spring.beans.RootBeanDefinition;
import com.chubin.simple.spring.exception.BeansException;
import com.chubin.simple.spring.factory.BeanFactory;
import com.chubin.simple.spring.utils.BeanUtils;

public class SimpleInstantiationStrategy  implements InstantiationStrategy{
	@Override
	public Object instantiate(RootBeanDefinition bd, String beanName, BeanFactory owner) {
		Class<?> beanClass = bd.getBeanClass();
		Constructor declaredConstructor = null;
		try{
			declaredConstructor = beanClass.getDeclaredConstructor();
		}catch(Exception e){
			throw new BeansException("No default constructor found");
		}
		return BeanUtils.instantiateClass(declaredConstructor);
	}
}
