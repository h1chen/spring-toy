package cn.h1chen.springframework.bean;

import cn.h1chen.springframework.beans.BeansException;
import cn.h1chen.springframework.beans.factory.*;
import cn.h1chen.springframework.context.ApplicationContext;

/**
 * @author h1chen
 */
public class UserService implements InitializingBean, DisposableBean, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private String name;
    private UserDao userDao;
    private String userId;
    private String company;
    private String location;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(userId) + "," + company + "," + location);
    }


    public UserService() {
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserService(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
