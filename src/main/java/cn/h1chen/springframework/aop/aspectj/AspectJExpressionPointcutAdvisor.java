package cn.h1chen.springframework.aop.aspectj;

import cn.h1chen.springframework.aop.Pointcut;
import cn.h1chen.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * 把 pointcut、拦截方法 Advice 和具体的拦截表达式包装在一起
 *
 * @author h1chen
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切点
    private AspectJExpressionPointcut pointcut;
    // 具体的拦截方法
    private Advice advice;
    // 表达式
    private String expression;


    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setPointcut(AspectJExpressionPointcut pointcut) {
        this.pointcut = pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
