package cn.h1chen.springframework.aop;

/**
 * @author h1chen
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
