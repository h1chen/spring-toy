package cn.h1chen.springframework.bean;

import cn.h1chen.springframework.beans.factory.FactoryBean;

/**
 * @author h1chen
 */
public class ProxyBeanFactory implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        System.out.println("ProxyBeanFactory ========");
        return new UserDao();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
