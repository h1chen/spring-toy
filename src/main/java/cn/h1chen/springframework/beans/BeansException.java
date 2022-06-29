package cn.h1chen.springframework.beans;

/**
 * 定义 Bean 异常
 *
 * @author h1chen
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
