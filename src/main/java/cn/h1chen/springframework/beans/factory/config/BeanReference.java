package cn.h1chen.springframework.beans.factory.config;

/**
 * bean 的引用
 *
 * @author h1chen
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
