package com.video.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.core.Ordered;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor 101010");

        AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("user");

        abstractBeanDefinition.setInitMethodName("init1");
        abstractBeanDefinition.setDestroyMethodName("destory1");

        MutablePropertyValues mutablePropertyValues = abstractBeanDefinition.getPropertyValues();
        mutablePropertyValues.addPropertyValue("name", "beanfactory modify name");


    }

    @Override
    public int getOrder() {
        return 10;
    }
}
