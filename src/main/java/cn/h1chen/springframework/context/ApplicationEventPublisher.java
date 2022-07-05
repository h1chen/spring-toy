package cn.h1chen.springframework.context;

/**
 * 事件发布者接口
 *
 * @author h1chen
 */
public interface ApplicationEventPublisher {

    /**
     * 发布事件
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);

}
