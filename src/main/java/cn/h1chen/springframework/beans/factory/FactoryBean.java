package cn.h1chen.springframework.beans.factory;

/**
 * 工厂 Bean， 用来构建复杂的对象实例
 *
 * @author h1chen
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
