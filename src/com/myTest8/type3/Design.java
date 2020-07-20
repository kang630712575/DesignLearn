package com.myTest8.type3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OptionalDataException;

/**
 * 抽象工厂模式：
 * 1、定义了一个interface用于创建相关或有依赖关系的对象簇，而无需指明具体的类
 * 2、抽象工厂模式可以将简单工厂模式和工厂方法模式进行整合
 * 3、从设计层面看，抽象工厂模式就是对简单工厂模式的改进(或者称为进一步的抽象)
 * 4、将工厂抽象成两层，AbsFactory(抽象工厂)和具体实现的工厂子类。程序员可以根据创建对象类型使用对应的工厂子类。这样将
 *    单个的简单工厂变成了工厂簇，更利于代码的维护和扩展
 */
public class Design {
}

abstract class Pizza1 {
    private String name;

    abstract void prepare();

    public void bake() {
        System.out.println(name + "baking;");
    }

    public void cut() {
        System.out.println(name + "cutting;");
    }

    public void box() {
        System.out.println(name + "boxing;");
    }

    void setName(String name) {
        this.name = name;
    }
}

class BJCheesePizza extends Pizza1 {

    @Override
    void prepare() {
        System.out.println("北京的奶酪披萨 正在准备材料...");
    }
}

class BJPepperPizza extends Pizza1 {

    @Override
    void prepare() {
        System.out.println("北京的胡椒披萨 正在准备材料...");
    }
}

class LDCheesePizza extends Pizza1 {

    @Override
    void prepare() {
        System.out.println("伦敦的奶酪披萨 正在准备材料...");
    }
}

class LDPepperPizza extends Pizza1 {

    @Override
    void prepare() {
        System.out.println("伦敦的胡椒披萨 正在准备材料...");
    }
}

// 抽象工厂
interface AbsFactory{
    // 目的是让下面的工厂子类来具体实现
    public Pizza1 createPizza1(String orderType);
}

class BJFactory implements AbsFactory{

    @Override
    public Pizza1 createPizza1(String orderType) {
        Pizza1 pizza1 = null;
        if(orderType.equals("cheese")){
            pizza1 = new BJCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza1 = new BJPepperPizza();
        }
        return pizza1;
    }
}

class LDFactory implements AbsFactory{

    @Override
    public Pizza1 createPizza1(String orderType) {
        Pizza1 pizza1 = null;
        if(orderType.equals("cheese")){
            pizza1 = new LDCheesePizza();
        }else if(orderType.equals("pepper")){
            pizza1 = new LDPepperPizza();
        }
        return pizza1;
    }
}

class OrderPizza{
    AbsFactory absFactory;

    // 构造器
    public OrderPizza(AbsFactory absFactory){
        setAbsFactory(absFactory);
    }
    private void setAbsFactory(AbsFactory absFactory){
        Pizza1 pizza1 = null;
        String orderType = "";
        this.absFactory = absFactory;
        do {
            orderType = getType();
            pizza1 = absFactory.createPizza1(orderType);
            if (pizza1 != null){
                pizza1.setName(orderType);
                pizza1.prepare();
                pizza1.bake();
                pizza1.cut();
                pizza1.box();
            }else{
                System.out.println("订购失败！");
                break;
            }
        }while(true);
    }

    private String getType() {
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入所需的pizza：");
            String str = strIn.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无此类pizza");
            return "";
        }
    }
}

class PizzaStore{
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}

