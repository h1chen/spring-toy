package cn.h1chen.springframework.context.event;

import cn.h1chen.springframework.beans.factory.BeanFactory;
import cn.h1chen.springframework.context.ApplicationEvent;
import cn.h1chen.springframework.context.ApplicationListener;

/**
 * @author h1chen
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener applicationListener : getApplicationListeners(event)) {
            applicationListener.onApplicationEvent(event);
        }
    }
}
