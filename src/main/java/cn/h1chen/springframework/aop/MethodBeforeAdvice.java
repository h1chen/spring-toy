package cn.h1chen.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author h1chen
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;

}
