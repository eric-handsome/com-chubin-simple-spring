package com.chubin.simple.spring.resource;

import com.chubin.simple.spring.utils.ClassUtils;

public class DefaultResourceLoader {

	private ClassLoader classLoader;
	
	
	public ClassLoader getClassLoader(){
		return (this.classLoader!=null ? this.classLoader : ClassUtils.getDefaultClassLoader());
	}
}
