package cn.h1chen.springframework.context.event;

import cn.h1chen.springframework.context.ApplicationContext;
import cn.h1chen.springframework.context.ApplicationEvent;

/**
 * @author h1chen
 */
public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
