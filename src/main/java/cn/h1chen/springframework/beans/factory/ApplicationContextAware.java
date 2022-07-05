package cn.h1chen.springframework.beans.factory;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.context.ApplicationContext;

/**
 * @author h1chen
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
