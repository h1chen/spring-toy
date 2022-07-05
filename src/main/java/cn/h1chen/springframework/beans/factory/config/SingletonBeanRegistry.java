package cn.h1chen.springframework.beans.factory.config;

/**
 * 单例注册表
 *
 * @author h1chen
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);

}
