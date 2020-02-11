package com.chubin.simple.spring.utils;

import com.chubin.simple.spring.factory.ConfigurationClassPostProcessor;

public class Conventions {

	public static String getQualifiedAttributeName(Class<?> enclosingClass, String attributeName) {
		// TODO Auto-generated method stub
		return enclosingClass.getName()+","+attributeName;
	}

	
}
