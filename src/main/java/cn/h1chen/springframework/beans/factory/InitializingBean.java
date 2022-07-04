package cn.h1chen.springframework.beans.factory;

/**
 * @author h1chen
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后使用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
