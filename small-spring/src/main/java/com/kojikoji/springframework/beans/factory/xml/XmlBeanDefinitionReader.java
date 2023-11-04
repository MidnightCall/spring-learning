package com.kojikoji.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.kojikoji.springframework.beans.BeansException;
import com.kojikoji.springframework.beans.PropertyValue;
import com.kojikoji.springframework.beans.factory.config.BeanDefinition;
import com.kojikoji.springframework.beans.factory.config.BeanReference;
import com.kojikoji.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.kojikoji.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.kojikoji.springframework.core.io.Resource;
import com.kojikoji.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName XmlBeanDefinitionReader
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 19:32
 * @Version
 */

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinition(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinition(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinition(resource);
        }
    }

    @Override
    public void loadBeanDefinition(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinition(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for(String location : locations) {
            loadBeanDefinition(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        // 获取xml一级节点集合
        Document doc = XmlUtil.readXML(inputStream);
        Element root = doc.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            // 判断是否为xml元素
            if(!(childNodes.item(i) instanceof Element))
                continue;
            // 判断是否为bean标签
            if(!"bean".equals(childNodes.item(i).getNodeName()))
                continue;
            // 解析标签属性
            Element bean = (Element) childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");

            // 获取class
            Class<?> clazz = Class.forName(className);

            // 获取beanName，优先级 id > beanName
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if(StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义Bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            // 循环读取属性并填充
            NodeList properties = bean.getChildNodes();
            for (int j = 0; j < properties.getLength(); j++) {
                // 属性合法性判断
                if(!(properties.item(j) instanceof Element))
                    continue;
                if(!"property".equals(properties.item(j).getNodeName()))
                    continue;
                // 解析属性内容
                Element property = (Element) properties.item(j);
                String attrName = property.getAttribute("name");
                String attrVal = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                // 判断是否为引用/val
                Object val = StrUtil.isEmpty(attrRef) ? attrVal : new BeanReference(attrRef);

                // 添加属性
                PropertyValue propertyValue = new PropertyValue(attrName, val);
                beanDefinition.getPropertyValues().addProperty(propertyValue);
            }
            if(getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册BeanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
