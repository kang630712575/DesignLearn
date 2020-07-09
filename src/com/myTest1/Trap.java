package com.myTest1;

public class Trap implements Observer{
    @Override
    public void update() {
        if(inRange()){
            System.out.println("夹住主角！");
        }
    }

    private boolean inRange(){
        return true;
    }
}
