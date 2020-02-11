package com.chubin.simple.spring.support;

import java.util.LinkedHashMap;
import java.util.Map;

import com.chubin.simple.spring.accessor.AttributeAccessor;

public abstract class AttributeAccessorSupport implements AttributeAccessor{
    private final Map<String,Object> attributes = new LinkedHashMap<>(0);
	
	@Override
	public Object getAtrribute(String name) {
		// TODO Auto-generated method stub
		return this.attributes.get(name);
	}
	
}
