package cn.h1chen.springframework.context.event;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.BeanFactory;
import cn.h1chen.springframework.beans.factory.BeanFactoryAware;
import cn.h1chen.springframework.context.ApplicationEvent;
import cn.h1chen.springframework.context.ApplicationListener;
import cn.h1chen.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 抽象事件广播器
 *
 * @author h1chen
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    private final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;


    @Override
    public void addApplicationListener(ApplicationListener<?> applicationListener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) applicationListener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> applicationListener) {
        applicationListeners.remove(applicationListener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 获取对该事件匹配的事件监听者
     *
     * @param event
     * @return
     */
    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        List<ApplicationListener> listeners = new ArrayList<>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportEvent(listener, event)) {
                listeners.add(listener);
            }
        }

        return listeners;
    }

    /**
     * 监听器是否对该事件感兴趣
     */
    private boolean supportEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 按照 CglibSubclassingInstantiationStrategy、SimpleInstantiationStrategy 不同的实例化类型，需要判断后获取目标 class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventCLassName;
        try {
            eventCLassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }

        // 判定此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同，或是否是其超类或超接口。
        return eventCLassName.isAssignableFrom(event.getClass());
    }
}
