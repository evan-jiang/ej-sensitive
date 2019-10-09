package com.ej.sensitive.dto;

import com.alibaba.fastjson.JSON;
import com.ej.sensitive.filter.SensitiveFilter;

public class SensitiveDto {

    public String toLogString(){
        return JSON.toJSONString(this,new SensitiveFilter());
    }

    public String toString(){
        return JSON.toJSONString(this);
    }
}
