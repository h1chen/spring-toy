package cn.h1chen.springframework.aop;

/**
 * 类匹配器
 *
 * @author h1chen
 */
public interface ClassFilter {

    /**
     * 用于切点找到指定的接口和目标类
     *
     * @param clazz
     * @return
     */
    boolean matcher(Class<?> clazz);

}
