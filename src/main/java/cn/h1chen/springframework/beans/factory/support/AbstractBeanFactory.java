package cn.h1chen.springframework.beans.factory.support;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.FactoryBean;
import cn.h1chen.springframework.beans.factory.config.BeanDefinition;
import cn.h1chen.springframework.beans.factory.config.BeanPostProcessor;
import cn.h1chen.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.h1chen.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h1chen
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object ShareInstance = getSingleton(name);
        if (ShareInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(ShareInstance, name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object instance, String beanName) {
        if (!(instance instanceof FactoryBean)) {
            return instance;
        }

        Object object = getCacheObjectForFactoryBean(beanName);
        if (object == null) {
            object = getObjectFromFactoryBean((FactoryBean<?>) instance, beanName);
        }

        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
