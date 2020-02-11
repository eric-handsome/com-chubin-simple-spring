package com.chubin.simple.spring.register;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.chubin.simple.spring.factory.ObjectFactory;

public class DefaultSingletonBeanRegistry {

	private final Map<String,ObjectFactory<?>> singletonFactories = new ConcurrentHashMap<>(16);
	
	private final Map<String,Object> singletonObjects = new ConcurrentHashMap<>(256);
	private Map<String,Object> earlySingletonObjects = new HashMap<>();
	
	//正在创建的bean的名字的集合
	private final Set<String> inCreationCheckExclusions = Collections.newSetFromMap(new ConcurrentHashMap<>(16));
	
	public  Object getSingleton(String beanName) {
		return getSingleton(beanName,true);
	}

	private Object getSingleton(String beanName, boolean allowEarlyReference) {
		Object singletonObject = this.singletonObjects.get(beanName);
		if(singletonObject == null && isSingletonCurrentlyInCreation(beanName)){
			synchronized (this.singletonObjects) {
				singletonObject = this.earlySingletonObjects.get(beanName);
				if(singletonObject == null && allowEarlyReference){
					ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
				   if(singletonFactory != null){
					   singletonObject = singletonFactory.getObject();
					   this.earlySingletonObjects.put(beanName, singletonObject);
					   this.singletonFactories.remove(beanName);
				   }	
				}
			}
		}
		return singletonObject;
	}

	private boolean isSingletonCurrentlyInCreation(String beanName) {
		// TODO Auto-generated method stub
		return this.inCreationCheckExclusions.contains(beanName);
	}
	
	public Object getSingleton(String beanName , ObjectFactory<?> singletonFactory){
		return null;
	}
}
