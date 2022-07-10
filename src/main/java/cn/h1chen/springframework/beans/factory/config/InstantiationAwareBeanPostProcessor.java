package cn.h1chen.springframework.beans.factory.config;

import cn.h1chen.springframework.beans.BeansException;

/**
 * @author h1chen
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {


    /**
     * 在 Bean对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
