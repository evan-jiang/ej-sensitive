package com.ej.sensitive.test;

import com.ej.sensitive.dto.OrderDto;
import com.ej.sensitive.dto.UserDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void example(){
        UserDto userDto = new UserDto();
        userDto.setAge(29);
        userDto.setName("张三丰");
        userDto.setBankCardNo("6222022000022222222");
        userDto.setCertiNo("430722199011111717");
        userDto.setPhoneNo("18888888888");
        userDto.setOtherInfo("Hello World");
        System.out.println(userDto.toLogString());
    }

    @org.junit.Test
    public void test(){
        UserDto userDto = new UserDto();
        userDto.setAge(30);
        userDto.setName("Evan");
        userDto.setBankCardNo("6000400032858687");
        userDto.setCertiNo("430722198811150639");
        userDto.setPhoneNo("15988881234");
        userDto.setOtherInfo("otherInfo");

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderNo("100000001");
        orderDto.setAmount(new BigDecimal(100.00));
        orderDto.setUserDto(userDto);
        List<OrderDto> orders = new ArrayList<>();
        orders.add(orderDto);
        System.out.println(orderDto.toLogString());
    }

    @org.junit.Test
    public void t1(){
        String value = "张三";
        String regex = "^(\\w{1})\\w*$";
        regex = "^([\\u4e00-\\u9fa5_\\w]{1})[\\u4e00-\\u9fa5_\\w]*([\\u4e00-\\u9fa5_\\w]{1})$";
        System.out.println(value.replaceAll(regex,"$1*$2"));
    }
}
