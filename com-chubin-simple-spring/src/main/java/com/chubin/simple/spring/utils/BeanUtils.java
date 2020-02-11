package com.chubin.simple.spring.utils;

import java.lang.reflect.Constructor;

import com.chubin.simple.spring.exception.BeansException;

public class BeanUtils {

	
	public static <T> T instantiateClass(Constructor<T> ctor , Object... args){
		try{
			return ctor.newInstance(args);
		}catch(Exception e){
			throw new BeansException("Is it an abstract class?");
		}
	}
}
