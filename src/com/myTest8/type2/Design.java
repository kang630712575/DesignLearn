package com.myTest8.type2;

import com.myTest8.type1.CheesePizza;
import com.myTest8.type1.Pizza;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 工厂方法模式：定义了一个创建对象的抽象方法，由子类决定要实例化的类。工厂方法模式将对象的实例化推迟到子类
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


abstract class OrderPizza {
    abstract Pizza1 createPizza1(String orderType);

    public OrderPizza() {
        Pizza1 pizza1 = null;
        String orderType = getType();
        pizza1 = createPizza1(orderType);
        if (pizza1 != null) {
            pizza1.setName(orderType);
            pizza1.prepare();
            pizza1.bake();
            pizza1.cut();
            pizza1.box();
        }
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

class BJOrderPizza extends OrderPizza {

    @Override
    Pizza1 createPizza1(String orderType) {
        Pizza1 pizza1 = null;
        if ("cheese".equals(orderType)) {
            pizza1 = new BJCheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza1 = new BJPepperPizza();
        }
        return pizza1;
    }
}

class LDOrderPizza extends OrderPizza {

    @Override
    Pizza1 createPizza1(String orderType) {
        Pizza1 pizza1 = null;
        if ("cheese".equals(orderType)) {
            pizza1 = new LDCheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza1 = new LDPepperPizza();
        }
        return pizza1;
    }
}

class PizzaStore {
    public static void main(String[] args) {
        new BJOrderPizza();
    }
}