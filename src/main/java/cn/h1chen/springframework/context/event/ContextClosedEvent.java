package cn.h1chen.springframework.context.event;

/**
 * 应用上下文关闭事件
 *
 * @author h1chen
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }

}
