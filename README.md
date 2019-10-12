# 日志脱敏
> 基于fastjson的过滤器对数据脱敏打印日志

## 脱敏类型
- NAME(姓名)：张三->张*
- BANKCARD(银行卡)：6222022000022222222->4307****1717
- IDCARD(身份证)：430722199011111717->4307****1717
- PHONE(手机号)：18888888888->188****888
- GENERAL(强制脱敏)：Hello World->*

## 构造数据对象类
```java
package com.ej.sensitive.dto;

import com.ej.sensitive.annotation.Sensitive;
import com.ej.sensitive.enums.SensitiveType;

public class UserDto extends SensitiveDto{

    private int age;
    @Sensitive(SensitiveType.NAME)
    private String name;
    @Sensitive(SensitiveType.IDCARD)
    private String certiNo;
    @Sensitive(SensitiveType.BANKCARD)
    private String bankCardNo;
    @Sensitive(SensitiveType.PHONE)
    private String phoneNo;
    @Sensitive(SensitiveType.GENERAL)
    private String otherInfo;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertiNo() {
        return certiNo;
    }

    public void setCertiNo(String certiNo) {
        this.certiNo = certiNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
```

## 实例
**实例代码**
```java
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
}
```
**运行结果**
```json
{"age":29,"bankCardNo":"6222****2222","certiNo":"4307****1717","name":"张三","otherInfo":"*","phoneNo":"188****888"}
```
