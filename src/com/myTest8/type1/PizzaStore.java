package com.myTest8.type1;

/**
 * 1、优点：比较好理解，简单易操作
 * 2、缺点：违反了设计模式的ocp原则，即对扩展开放，对修改关闭。当我们给类增加新功能时，尽量不修改代码，或者尽可能少的修改代码
 */
public class PizzaStore {

    public static void main(String[] args) {
        new OrderPizza();
    }
}


