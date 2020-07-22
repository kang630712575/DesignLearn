package com.myTest9.type1;

/**
 * 原型模式-基本介绍
 * 1、原型模式(Prototype)是指：用原型实例指定创建对象的种类，并且通过拷贝这些原型，创建新的对象;
 * 2、原型模式是一种创建型设计模式，允许一个对象在创建另一个可定制的对象，无需知道如何创建的细节;
 * 3、工作原理是：通过将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝他们自己来实施创建，即对象.clone();
 */
public class Prototype {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom",1,"blue");
        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();
    }
}

class Sheep implements Cloneable{
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

    @Override
    protected Object clone(){
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}

/**
 * 浅拷贝介绍：
 * 1、对于数据类型是基本数据类型的成员变量，浅拷贝会
 */
