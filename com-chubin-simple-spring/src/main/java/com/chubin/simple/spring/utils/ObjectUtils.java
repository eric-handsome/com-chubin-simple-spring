package com.chubin.simple.spring.utils;

import java.util.Optional;

public class ObjectUtils {

	public static Object unwrapOptional(Object object) {
		if(object instanceof Optional){
			Optional<?> optional = (Optional<?>)object;
			if(!optional.isPresent()){
				return null;
			}
			Object result = optional.get();
			return result;
		}
		return object;
	}

}
