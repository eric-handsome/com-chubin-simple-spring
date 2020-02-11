package com.chubin.simple.spring.context;

import java.util.ArrayList;
import java.util.List;

import com.chubin.simple.spring.delegate.PostPcocessorRegistrationDelegate;
import com.chubin.simple.spring.factory.ConfigurableListableBeanFactory;
import com.chubin.simple.spring.processor.ApplicationContextAwareProcessor;
import com.chubin.simple.spring.processor.BeanFactoryPostProcessor;
import com.chubin.simple.spring.resource.DefaultResourceLoader;

public abstract class AbstractApplicationContext extends DefaultResourceLoader
		implements ConfigurableApplicationContext {

	private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<>();

	public void refresh() {

		// 获取beanFctory
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();

		prepareBeanFactory(beanFactory);

		try {
			postProcessBeanFactory(beanFactory);

			invokeBeanFactoryPostProcessors(beanFactory);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {

		PostPcocessorRegistrationDelegate.invokeBeanDactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
	}

	private List<BeanFactoryPostProcessor> getBeanFactoryPostProcessors() {
		// TODO Auto-generated method stub
		return beanFactoryPostProcessors;
	}

	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {

	}

	private void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		beanFactory.setBeanClassLoader(getClassLoader());
		beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor());
	}

	public boolean containsBeanDefinition(String beanName) {
		return getBeanFactory().containsBeanDefinition(beanName);
	}

	public abstract ConfigurableListableBeanFactory getBeanFactory();

	public String[] getBeanDefinitionNames() {
		return getBeanFactory().getBeanDefinitionNames();
	};
}
