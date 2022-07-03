package cn.h1chen.springframework.context;

import cn.h1chen.springframework.beans.BeansException;

/**
 * @author h1chen
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     */
    void refresh() throws BeansException;

}
