package com.myTest1;

import java.util.ArrayList;
import java.util.List;

// 定义一个被观察者
abstract public class Subject {
    private List<Observer> observerList = new ArrayList<Observer>();

    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    public void detachObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observerList){
            observer.update();
        }
    }
}
