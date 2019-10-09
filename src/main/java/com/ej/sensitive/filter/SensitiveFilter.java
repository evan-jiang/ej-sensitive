package com.ej.sensitive.filter;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.ej.sensitive.annotation.Sensitive;
import com.ej.sensitive.enums.SensitiveType;

import java.lang.reflect.Field;

public class SensitiveFilter implements ValueFilter {
    @Override
    public Object process(Object obj, String name, Object value) {
        if (value == null) {
            return null;
        }
        if (!(value instanceof String)) {
            return value;
        }
        SensitiveType sensitiveType = null;
        try {
            Field field = obj.getClass().getDeclaredField(name);
            Sensitive sensitive = field.getAnnotation(Sensitive.class);
            sensitiveType = sensitive == null ? null : sensitive.value();
        } catch (NoSuchFieldException e) {
            return value;
        }
        if (sensitiveType == null) {
            return value;
        }
        Object newValue = null;
        String oldValue = (String) value;
        /*switch (sensitiveType) {
            case NAME:
                break;
            case IDCARD:
                break;
            case BANKCARD:
                break;
            default:
                break;
        }*/
        newValue = sensitiveType.convert(oldValue);
        return newValue;
    }
}
