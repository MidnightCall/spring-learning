package com.kojikoji.springframework;

import com.kojikoji.springframework.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PropertyValues
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/21 19:17
 * @Version
 */

public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for(PropertyValue pv : this.propertyValueList) {
            if(pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
