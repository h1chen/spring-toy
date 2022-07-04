package cn.h1chen.springframework.beans.factory;

/**
 * @author h1chen
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
