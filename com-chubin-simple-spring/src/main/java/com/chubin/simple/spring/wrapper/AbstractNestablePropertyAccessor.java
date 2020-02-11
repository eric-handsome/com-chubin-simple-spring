package com.chubin.simple.spring.wrapper;

import com.chubin.simple.spring.utils.ObjectUtils;

public abstract class AbstractNestablePropertyAccessor {

	private Object wrappedObject; 
	
	public AbstractNestablePropertyAccessor(Object object) {
		setWrappedInstance(object);
	}

	public  void setWrappedInstance(Object object) {
		this.wrappedObject = ObjectUtils.unwrapOptional(object);
	}

	public final Object getWrappedInstance(){
		return this.wrappedObject; 
	};
	
	public final Class<?> getWrappedClass(){
		return getWrappedInstance().getClass();
	};
	
}
