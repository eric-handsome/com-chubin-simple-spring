package com.chubin.simple.spring.accessor;

public interface AttributeAccessor {

	
	void setAttribute(String name, Object value);
	
	Object getAtrribute(String name);
	
	String[] attributeNames();
	
	
}
