package cn.h1chen.springframework.context;

import java.util.EventObject;

/**
 * 具备事件功能的抽象类，后续所有事件的类都需要继承这个类
 *
 * @author h1chen
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
