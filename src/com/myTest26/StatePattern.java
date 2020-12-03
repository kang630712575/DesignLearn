package com.myTest26;

import java.util.Random;

/**
 * 状态模式:
 * 1.状态模式(state pattern):只要用来解决对象在多种状态转换时，需要对外输出不同的行为的问题。状态和行为是一一对应的，状态之间可以相互转换
 * 2.当一个对象的内在状态改变时，允许改变其行为，这个对象看起来像是改变了其类
 */
public class StatePattern {

    public static void main(String[] args) {
        RaffleActivity activity  = new RaffleActivity(1);

        for(int i = 0; i < 300 ; i++){
            System.out.println("---------------第" + (i + 1) + "次抽奖---------------");

            /*activity.deductMoney();

            avtivity.raffle();*/
        }
    }
}

abstract class State{
    public abstract void deductMoney();

    public abstract boolean raffle();

    // public abstract void dispensePrize();
}

class CanRaffleState extends State{
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity){
        this.activity = activity;
    }

    @Override
    public void deductMoney(){
        System.out.println("已扣取过积分");
    }

    @Override
    public boolean raffle(){
        System.out.println("正在抽奖，请稍等...");
        Random r = new Random();
        int num = r.nextInt(10);

        if(num == 0){
            activity.setState(activity.getDispenseState());
            return true;
        }else {
            System.out.println("很遗憾没有抽中奖品！");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }
}


class DispenseOutState extends State{
    RaffleActivity activity;

    public DispenseOutState( RaffleActivity activity){
        this.activity = activity;
    }

    @Override
    public void deductMoney(){
        System.out.println("奖品发送完了，请下次参加");
    }

    @Override
    public boolean raffle(){
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }
}

class DispenseState extends State{
    RaffleActivity activity;

    public DispenseState( RaffleActivity activity){
        this.activity = activity;
    }

    @Override
    public void deductMoney(){
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle(){
        System.out.println("不能抽奖");
        return false;
    }
}


class NoRaffleState extends State{
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity){
        this.activity = activity;
    }

    @Override
    public void deductMoney(){
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle(){
        System.out.println("扣了积分才能抽奖");
        return false;
    }
}

class RaffleActivity{
    State state = null;

    int count = 0;
    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);

    State dispenseState = new DispenseState(this);
    State dispenseOutState = new DispenseOutState(this);

    public RaffleActivity(int count){
        this.state = getNoRaffleState();
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(State noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(State dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
















