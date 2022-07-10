package cn.h1chen.springframework.aop;

import java.lang.reflect.Method;

/**
 * 方法匹配器
 *
 * @author h1chen
 */
public interface MethodMatcher {

    /**
     * 用来找到表达式范围内匹配下的目标类和方法
     *
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);

}
