package cn.h1chen.springframework.beans.factory.support;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 该类处理关于 FactoryBean 此类对象的注册操作。</br>
 * 单独一个类的原因是，希望做到不同领域模块下只负责各自需要完成的功能，避免因为拓展导致类膨胀到难以维护
 *
 * @author h1chen
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    // 缓存通过 FactoryBean 创建出来的对象
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();


    protected Object getCacheObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return object != NULL_OBJECT ? object : null;
    }

    protected Object getObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }

            return object != NULL_OBJECT ? object : null;
        } else {
            return doGetObjectFromFactoryBean(factoryBean, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean throw exception on object[" + beanName + "] creation", e);
        }
    }
}
