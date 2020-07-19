package com.myTest8.type1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 简单工厂模式
 * 基本介绍：
 * 1、简单工厂模式是属于创建型模式，是工厂模式的一种。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式
 *    是工厂模式家族中最简单实用的模式
 * 2、简单工厂模式：定义了一个创建对象的类，由这个类来封装实例化对象的行为(代码)
 * 3、在软件开发中，当我们会用到大量的创建某种、某类或者某批对象时，就会使用到工厂模式
 */
public class SimpleFactory {
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if(orderType.equals("greek")){
            pizza = new GreekPizza();
        }else if(orderType.equals("cheese")){
            pizza = new CheesePizza();
        }
        return pizza;
    }
}

class OrderPizza1{
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza1(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }
    public void setFactory(SimpleFactory simpleFactory){
        String orderType = "";
        this.simpleFactory = simpleFactory;
        do{
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            if(pizza != null){
                pizza.setName(orderType);
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("无此类披萨");
                break;
            }
        }while (true);
    }

    private String getType(){
        try{
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strIn.readLine();
            return str;
        }catch(Exception e){
            e.printStackTrace();
            return "";
        }
    }

}

class PizzaStore1{
    public static void main(String[] args) {
        new OrderPizza1(new SimpleFactory());
    }
}


