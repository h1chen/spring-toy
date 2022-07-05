package cn.h1chen.springframework.beans.factory;

import cn.h1chen.springframework.beans.BeansException;

/**
 * @author h1chen
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;

}
