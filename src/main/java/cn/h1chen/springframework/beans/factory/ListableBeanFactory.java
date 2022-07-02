package cn.h1chen.springframework.beans.factory;

import cn.h1chen.springframework.beans.BeansException;

import java.util.Map;

/**
 * 可枚举的 Bean Factory
 *
 * @author h1chen
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

    /**
     * 按照类型返回 Bean 实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

}
