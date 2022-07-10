package cn.h1chen.springframework.aop;

/**
 * 切入点接口
 *
 * @author h1chen
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
