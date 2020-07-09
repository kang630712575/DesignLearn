package com.myTest1;

// 定义一个怪物类
public class Monster implements Observer{
    @Override
    public void update() {
        if(inRange()){
            System.out.println("怪物对主角攻击！");
        }
    }

    private boolean inRange(){
        return true;
    }
}
