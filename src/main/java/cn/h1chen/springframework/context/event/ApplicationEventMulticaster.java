package cn.h1chen.springframework.context.event;

import cn.h1chen.springframework.context.ApplicationEvent;
import cn.h1chen.springframework.context.ApplicationListener;

/**
 * 事件广播器
 *
 * @author h1chen
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加事件监听者
     *
     * @param applicationListener
     */
    void addApplicationListener(ApplicationListener<?> applicationListener);

    /**
     * 移除事件监听者
     *
     * @param applicationListener
     */
    void removeApplicationListener(ApplicationListener<?> applicationListener);

    /**
     * 广播事件到对应的事件监听者
     *
     * @param event
     */
    void multicastEvent(ApplicationEvent event);

}
