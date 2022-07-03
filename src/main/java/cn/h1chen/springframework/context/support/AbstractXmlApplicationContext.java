package cn.h1chen.springframework.context.support;

import cn.h1chen.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.h1chen.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author h1chen
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
