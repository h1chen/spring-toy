package cn.h1chen.springframework.beans.factory.config;

import cn.h1chen.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author h1chen
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}