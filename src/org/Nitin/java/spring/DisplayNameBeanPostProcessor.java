//***************************************
//Initial Codes changes for 20/12/2015
//***************************************
package org.Nitin.java.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("#BeanPostProcessor - postProcessAfterInitialization #After. Bean name: " + beanName );
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("#BeanPostProcessor - postProcessBeforeInitialization #Before. Bean name: " + beanName );
		return bean;
	}

}
