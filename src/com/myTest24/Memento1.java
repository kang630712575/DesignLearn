package com.myTest24;


import com.myTest2.Car;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 * 1、备忘录模式(Memento Pattern)在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样以后就可将该对象恢复
 *    到原先保存的状态
 * 2、可以这里理解备忘录模式：现实生活中的备忘录是用来记录某些要去做的事情，或者是记录已经达成的共同意见的事情，以防忘记了，而在软件层面
 *    备忘录模式有着相同的含义，备忘录对象主要用来记录一个对象的某种状态，或者某些数据，当要做回退时，可以从备忘录对象里获取原来的数据进
 *    行恢复操作
 * 3、备忘录模式属于行为模式
 */

/**
 * 备忘录模式的注意事项和细节
 * 1、给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态
 * 2、实现了信息的封装，使得用户不需要关心状态的保存细节
 * 3、如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存
 * 4、适用的场景：后悔药、打游戏时的存档、window里的Crtl + z、IE中的后退、数据库的事项管理
 * 5、为了节约内存，备忘录模式可以和原型模式配合使用
 */
public class Memento1 {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("状态1");
        careTaker.add(originator.saveState());

        originator.setState("状态2   攻击力80");
        careTaker.add(originator.saveState());

    }
}


class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 编写一个方法，可以保存一个状态对象Memento
    // 因此编写一个方法，返回Memento
    public Memento saveState(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}

class Memento{
    private String state;
    public Memento(String state){
        super();
        this.state = state;
    }

    public String getState(){
        return state;
    }
}


class CareTaker{
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}










