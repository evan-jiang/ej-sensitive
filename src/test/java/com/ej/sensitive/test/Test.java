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
        userDto.setName("张三");
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
        String value = "430722198811150719";
        System.out.println(value.replaceAll("^(\\d{4})\\d{8,10}(\\d{4}|(\\d{3}(X|x)))$", "$1****$2"));
        System.out.println(value.replaceAll("^(\\d{3})\\d*(\\d{3})$", "$1****$2"));
    }
}
