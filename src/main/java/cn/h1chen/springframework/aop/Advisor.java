package cn.h1chen.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author h1chen
 */
public interface Advisor {

    Advice getAdvice();

}
