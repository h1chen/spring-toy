package cn.h1chen.springframework.beans.factory.config;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.xml.ConfigurableListableBeanFactory;

/**
 * @author h1chen
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
