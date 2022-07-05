package cn.h1chen.springframework.context.support;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.h1chen.springframework.beans.factory.config.BeanPostProcessor;
import cn.h1chen.springframework.beans.factory.support.ApplicationContextAwareProcessor;
import cn.h1chen.springframework.beans.factory.xml.ConfigurableListableBeanFactory;
import cn.h1chen.springframework.context.ApplicationEvent;
import cn.h1chen.springframework.context.ApplicationListener;
import cn.h1chen.springframework.context.ConfigurableApplicationContext;
import cn.h1chen.springframework.context.event.ApplicationEventMulticaster;
import cn.h1chen.springframework.context.event.ContextClosedEvent;
import cn.h1chen.springframework.context.event.ContextRefreshedEvent;
import cn.h1chen.springframework.context.event.SimpleApplicationEventMulticaster;
import cn.h1chen.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

/**
 * @author h1chen
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 1、创建 BeanFactory, 并加载 BeanDefinition
        refreshBeanFactory();

        // 2、获取 BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3、添加 ApplicationContextAwareProcessor， 让继承 ApplicationContextAware 的 Bean 对象可以感知到所属的 ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4、在 Bean 实例化之前，执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessor(beanFactory);

        // 5、BeanPostProcessor 需要提前与其他 Bean 对象实例化之前执行注册操作
        registerBeanPostProcessor(beanFactory);

        // 6、初始化事件广播器
        initApplicationEventMulticaster();

        // 7、注册事件监听器
        registerListeners();

        // 8、提前实例化单例 Bean 对象
        beanFactory.preInstantiateSingletons();

        // 9. 发布容器刷新完成事件
        finishRefresh();
    }

    private void finishRefresh() {
        publishEvent(new ContextRefreshedEvent(this));
    }

    private void initApplicationEventMulticaster() {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener : applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void registerBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }

    }

    private void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory() throws BeansException;


    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBeanDefinition(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }


    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        // 发布容器关闭时间
        publishEvent(new ContextClosedEvent(this));

        // 执行销毁单例 Bean 的销毁方法
        getBeanFactory().destroySingletons();
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        applicationEventMulticaster.multicastEvent(event);
    }
}
