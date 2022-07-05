package cn.h1chen.springframework.context;

import java.util.EventListener;

/**
 * 事件监听者
 *
 * @author h1chen
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理事件
     *
     * @param event
     */
    void onApplicationEvent(E event);

}
