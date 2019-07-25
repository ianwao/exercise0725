package com.ianw.bootdemo.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class User {

    @NotBlank(message = "名字不能为空")
    private String pername;

    @Range(min = 15, max = 100, message = "年龄必须为15-100岁")
    private Integer age;

    @Range(min = 11, max = 11, message = "电话号必须为11位")
    private String mobile;

    @Override
    public String toString() {
        return "User{" +
                "pername='" + pername + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @NotBlank(message = "简介不能为空")
    private String description;

    @NotNull(message = "登录名不能为空")
    @Length(min = 4, max = 10, message = "登录名长度必须为4-10位")
    private String username;

    @NotNull(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码长度必须为6-18位")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
