package com.chubin.simple.spring.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StringUtils {

	public static String[] toStringArray(Collection<String> collection) {
		// TODO Auto-generated method stub
		return collection.toArray(new String[collection.size()]);
	}

}
