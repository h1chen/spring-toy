package cn.h1chen.springframework.context;

import cn.h1chen.springframework.beans.factory.HierarchicalBeanFactory;
import cn.h1chen.springframework.beans.factory.ListableBeanFactory;
import cn.h1chen.springframework.core.io.ResourceLoader;

/**
 * @author h1chen
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
