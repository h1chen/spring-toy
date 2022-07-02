package cn.h1chen.springframework.beans.factory.support;

import cn.h1chen.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition 注册表
 *
 * @author h1chen
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName);

    boolean containBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

}
