package cn.h1chen.springframework.beans.factory;

import cn.h1chen.springframework.beans.BeansException;

/**
 * @author h1chen
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
