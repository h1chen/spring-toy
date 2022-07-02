package cn.h1chen.springframework.core.io;

/**
 * 资源加载器
 *
 * @author h1chen
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
