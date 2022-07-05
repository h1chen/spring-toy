package cn.h1chen.springframework.context.event;

/**
 * 应用上下文刷新事件
 *
 * @author h1chen
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }

}
