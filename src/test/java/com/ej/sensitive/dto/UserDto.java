package com.ej.sensitive.dto;

import com.ej.sensitive.annotation.Sensitive;
import com.ej.sensitive.enums.SensitiveType;

public class UserDto {

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
