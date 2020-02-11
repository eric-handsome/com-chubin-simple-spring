package com.chubin.simple.spring.utils;

public class ClassUtils {

	public static ClassLoader getDefaultClassLoader(){
		ClassLoader cl = null;
		try{
			cl = Thread.currentThread().getContextClassLoader();
		}catch(Throwable e){
		}
		if(cl ==null){
			cl = ClassUtils.class.getClassLoader();
			if(cl == null){
				try{
					cl = ClassLoader.getSystemClassLoader();
				}catch(Throwable ex){
					
				}
			}
		}
		return cl;
	}
}
