package com.myTest8.type1;

import com.myTest8.type1.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

    public OrderPizza(){
        Pizza pizza = null;
        String orderType;
        do{
            orderType = getType();
            if("greek".equals(orderType)){
                pizza = new GreekPizza();
            }else if("cheese".equals(orderType)){
                pizza = new CheesePizza();
            }else{
                break;
            }
            // 输出pizza制作过程
            pizza.setName(orderType+"  ");
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
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
