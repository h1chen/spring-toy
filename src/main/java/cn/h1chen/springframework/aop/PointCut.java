package cn.h1chen.springframework.aop;

/**
 * 切入点接口
 *
 * @author h1chen
 */
public interface PointCut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
