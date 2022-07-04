package cn.h1chen.springframework.beans.factory.xml;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.ListableBeanFactory;
import cn.h1chen.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.h1chen.springframework.beans.factory.config.BeanDefinition;
import cn.h1chen.springframework.beans.factory.config.BeanPostProcessor;
import cn.h1chen.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 在 Spring 源码中，具有可修改、可枚举 Bean 的功能，同时是可获取父 BeanFactory的
 *
 * @author h1chen
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
