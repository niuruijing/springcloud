package com.hj.feign.entity;

/**
 * Created by niuruijing on 2018/4/25.
 */
public class User {
    private String name;
    private String age;

    //必须要有默认的构造函数，否则feign根据json字符串转换user的时候会报异常
    public User(){

    }

    public User(String name, String age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
