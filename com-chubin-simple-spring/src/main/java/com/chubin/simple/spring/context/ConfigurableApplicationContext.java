package com.chubin.simple.spring.context;

import org.w3c.dom.views.AbstractView;

import com.chubin.simple.spring.factory.ConfigurableListableBeanFactory;
import com.chubin.simple.spring.factory.ListableBeanFactory;

public interface ConfigurableApplicationContext extends ListableBeanFactory{

	ConfigurableListableBeanFactory getBeanFactory();
}
