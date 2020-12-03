package com.myTest23;

import javax.print.attribute.standard.Media;

/**
 * 中介者模式(Mediator Pattern)
 * 1、用一个中介对象来封装一系列的对象交互，中介者使各个对象不需要显式的相互引用，从而使其耦合松散，而且可以独立的改变他们之间的交互
 * 2、中介者模式属于行为模式，使代码易于维护
 * 3、比如MVC模式，C(Controller控制器)是M（Model模型）和V（view视图）的中介者，在前后端交互时起到了中间人的作用
 */

/**
 * 中介者模式的注意事项和细节
 * 1、多个类相互耦合，会形成网状结构，使用中介者模式将网状结构分离为星型结构，进行解耦
 * 2、减少类间依赖，降低了耦合，符合迪米特原则
 * 3、中介者承担了较多的责任，一旦中介者出现了问题，这个系统就会受到影响
 * 4、如果设计不当，中介者对象本身变的过于复杂，这点在实际使用时，要特别注意
 */
class Mediator1 {
}


abstract class Colleague{
    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator,String name){
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator(){
        return this.mediator;
    }

    public abstract void SendMessage(int stateChange);

}

class Alarm extends Colleague{
    public Alarm(Mediator mediator,String name){
        super(mediator,name);
        mediator.Register(name,this);
    }

    public void sendAlarm(int stateChange){
        SendMessage(stateChange);
    }

    @Override
    public void SendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }
}

abstract class Mediator{
    public abstract void Register(String colleagueName,Colleague colleague);
    public abstract void getMessage(int stateChange,String colleagueName);
    public abstract void SendMessage();
}
















