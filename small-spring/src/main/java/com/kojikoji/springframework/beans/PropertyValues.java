package com.kojikoji.springframework.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PropertyValues
 * @Description BeanDefinition属性集合
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/8/20 16:02
 * @Version
 */

public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addProperty(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if(propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
