package com.myTest9.type1;

import java.io.*;

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
 * 1、对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性值复制给一份新的对象
 * 2、对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，也就是只是将该成员变量
 *    的引用指（内存地址）复制一份给新的对象。因为实际上两个对象的该成员变量都指向同一个实例。在这种情况下。在一个对象中修改该成员变量
 *    会影响倒另一个对象的该成员变量值。
 * 3、浅拷贝是使用默认的clone()方法实现的。sheep = (Sheep)super.clone();
 */

/**
 * 深拷贝介绍：
 * 1、复制对象的所有基本数据类型的成员变量值
 * 2、为所有引用数据类型的成员变量申请存储空间，并复制每个引用数据类型成员变量所引用的对象，直到该对象可达的所有对象。也就是说，对象
 *    进行深拷贝要对整个对象进行拷贝
 * 3、深拷贝实现方式1：重写clone方法来实现深拷贝
 * 4、深拷贝实现方式2：通过对象序列化实现深拷贝
 */

/**
 * 原型模式的注意事项和细节
 * 1、创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率
 * 2、不用重新初始化对象，而是动态的获得对象运行时的状态
 * 3、如果原始对象发生变化(增加或减少属性)，其他克隆对象的也会发生相应的变化，无需修改代码
 * 4、在实现深克隆的时候可能需要比较复杂的代码
 * 5、缺点：需要为每一个类配备一个克隆的方法，这对全新的类来说不是很难，但对已有的类进行改造，需要修改其源代码，违背了ocp原则
 */

class DeepCloneableTarget implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    public  DeepCloneableTarget(String cloneName,String cloneClass){
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    // 因为该类的属性都是String，因此我们用默认的clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class DeepPrototype implements Serializable,Cloneable{
    private String name;
    private DeepCloneableTarget deepCloneableTarget; // 引用类型

    public DeepPrototype(){
        super();
    }

    // 深拷贝 - 方式1 使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        // 此处完成对基本数据类型(属性)和String的克隆
        deep = super.clone();
        // 对引用类型进行单独处理
        DeepPrototype deepPrototype = (DeepPrototype)deep;
        deepPrototype.deepCloneableTarget = (DeepCloneableTarget)deepCloneableTarget.clone();
        return deepPrototype;
    }

    // 深拷贝 - 方式2 通过对象序列化实现(推荐)
    public Object deepClone(){
        // 创建流对象
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try{
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepPrototype deepPrototype = (DeepPrototype)ois.readObject();
            return deepPrototype;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
    }
}


















