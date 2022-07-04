package cn.h1chen.springframework.beans.factory.support;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.DisposableBean;
import cn.h1chen.springframework.beans.factory.config.BeanDefinition;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Method;

/**
 * 销毁方法适配器，将 DisposableBean 和 destroy-method 统一进行处理
 *
 * @author h1chen
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1、实现 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 配置信息 destroy-method
        if (StrUtil.isNotBlank(this.destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (method == null) {
                throw new BeansException("Could not find an destroy method named " + destroyMethodName + " on bean with name '" + beanName + "'");
            }

            method.invoke(bean);
        }
    }
}
