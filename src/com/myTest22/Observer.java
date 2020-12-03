package com.myTest22;


import java.util.ArrayList;

/**
 * 观察者模式原理
 * 观察者模式:对象之间多对一依赖的一种设计方案,被依赖的对象为Subjct,依赖的对象为Observer,Subject通知Observer变化,比如这里的奶站是
 *           Subject,是1的一方,用户是Observer,是多的一方
 * 优缺点:
 * 1、观察者模式设计后,会以集合的方式来管理用户(Observer),包括注册,移除和通知
 * 2、这样,我们增加观察者(这里可以理解成一个新的公告板),就不需要去修改核心类WeatherData不会修改代码了,遵守了ocp原则
 */
public class Observer {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();

        weatherData.registerObserver(currentConditions);

        System.out.println("通知各个注册表的观察者,查看信息");
        weatherData.setData(10f,100f,30.3f);
    }
}


interface Subject{
    public void registerObserver(Observer1 o);
    public void removeObserver(Observer1 o);
    public void notifyObserver();
}

interface Observer1{
    public void update(float temperature,float pressure,float humidity);
}


class CurrentConditions implements Observer1 {
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    // 显示
    public void display(){
        System.out.println("*****Today mTemperature:" + temperature + "*****");
        System.out.println("*****Today mPressure:" + pressure + "*****");
        System.out.println("*****Today mHumidity:" + humidity + "*****");
    }
}


class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;
    private ArrayList<Observer1> observer1s;

    public WeatherData() {
        observer1s = new ArrayList<Observer1>();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public CurrentConditions getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }

    public void dataChange(){
        notifyObserver();
    }

    // 注册一个观察者
    @Override
    public void registerObserver(Observer1 o) {
        observer1s.add(o);
    }

    // 移除一个观察者
    @Override
    public void removeObserver(Observer1 o) {
        if(observer1s.contains(o)){
            observer1s.remove(o);
        }
    }

    // 遍历所有观察者
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observer1s.size(); i++) {
            observer1s.get(i).update(getTemperature(),getPressure(),getHumidity());
        }
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}













