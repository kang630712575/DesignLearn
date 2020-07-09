package com.myTest1;

public class Hero extends Subject{
    void move(){
        System.out.println("主角向前移动");
        notifyObservers();
    }
}
