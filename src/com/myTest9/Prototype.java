package com.myTest9;

/**
 * 传统方法解决克隆问题优缺点：
 * 1、优点：比较好理解，简单易操作
 * 2、缺点：①在创建新的对象时，总需要重新获取原始对象的属性，如果创建的对象比较复杂时，效率较低
 *         ②总是需要重新初始化对象，而不是动态的获取对象运行时的状态，不够灵活
 * 改进思路：Java中Object类是所有类的根类，Object类提供了一个clone()方法，该方法可以将一个java对象复制一份，但是需要实现clone的java类
 *          必须要实现一个接口Cloneable，该接口表示该类能够复制且具有复制的能力 => 原型模式
 */
public class Prototype {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",1,"白色");
        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
    }
}

class Sheep{
    private String name;
    private Integer age;
    private String color;

    public Sheep(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
