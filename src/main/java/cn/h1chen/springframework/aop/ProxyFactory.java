package cn.h1chen.springframework.aop;

import cn.h1chen.springframework.aop.framework.AdvisedSupport;
import cn.h1chen.springframework.aop.framework.AopProxy;
import cn.h1chen.springframework.aop.framework.Cglib2AopProxy;
import cn.h1chen.springframework.aop.framework.JDKDynamicAopProxy;

/**
 * @author h1chen
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }

        return new JDKDynamicAopProxy(advisedSupport);
    }

}
