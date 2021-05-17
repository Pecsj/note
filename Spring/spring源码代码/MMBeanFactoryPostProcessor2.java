package com.video.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.core.Ordered;

public class MMBeanFactoryPostProcessor2 implements BeanFactoryPostProcessor, Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MMBeanFactoryPostProcessor5");

        AbstractBeanDefinition abstractBeanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("user");

        MutablePropertyValues pv = abstractBeanDefinition.getPropertyValues();
        pv.addPropertyValue("name", "name is changed from bean factory post processor");
        abstractBeanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        abstractBeanDefinition.setLazyInit(true);
        abstractBeanDefinition.setInitMethodName("init1");
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
