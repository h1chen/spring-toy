package cn.h1chen.springframework.common;


import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.PropertyValue;
import cn.h1chen.springframework.beans.PropertyValues;
import cn.h1chen.springframework.beans.factory.config.BeanDefinition;
import cn.h1chen.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.h1chen.springframework.beans.factory.xml.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
