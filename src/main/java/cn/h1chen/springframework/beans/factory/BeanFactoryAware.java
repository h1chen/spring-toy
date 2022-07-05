package cn.h1chen.springframework.beans.factory;

import cn.h1chen.springframework.beans.BeansException;

/**
 * @author h1chen
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
