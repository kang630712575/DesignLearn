package com.myTest3.DIP;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * 依赖倒转原则(Dependence Inversion Principle)
 * 1.高层模块不应该依赖低层模块，二者都应该依赖其抽象(抽象类、接口)
 * 2.抽象不应该依赖细节，细节应该依赖抽象
 * 3.依赖倒转的中心思想是面向接口编程
 * 4.依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要更稳定，以抽象为基础搭建的架构比以细节为基础的架构稳定的多。
 * 在java中，抽象指的是接口或抽象类，细节就是具体的实现类
 * 5.使用接口或抽象类的目的是制定好规范，而不涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成
 */
public class DIPrinciple {
    public static void main(String[] args) {
        Person p = new Person();
        p.sendMessage(new SendTools());
    }
}

interface Receiver{
    void sendEmail();
    void sendWeChat();
    void sendNote();
}

class Person{
    void sendMessage(Receiver receiver){
        receiver.sendEmail();
    }
}

class SendTools implements Receiver{

    @Override
    public void sendEmail() {
        System.out.println("电子邮件已发送...");
    }

    @Override
    public void sendWeChat() {
        System.out.println("微信消息已发送...");
    }

    @Override
    public void sendNote() {
        System.out.println("短信已发送...");
    }
}

//依赖传递方式
//1.通过接口传递实现依赖
/*interface IOpenAndClose{
    void open(ITV tv);
}

interface ITV{
    void play();
}

class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITV tv) {
        tv.play();
    }
}*/

//2.通过构造方法依赖传递
/*
interface IOpenAndClose{
    public void open();
}

interface ITV{
    void play();
}

class OpenAndClose implements IOpenAndClose{
    public ITV tv;
    public OpenAndClose(ITV tv){
        this.tv = tv;
    }
    @Override
    public void open() {
        this.tv.play();
    }
}
*/
//3.通过setter方法传递
interface IOpenAndClose{
    void open();
    void setTv(ITV tv);
}

interface ITV{
    void play();
}

class OpenAndClose implements IOpenAndClose{

    private ITV tv;
    @Override
    public void open() {
        this.tv.play();
    }

    @Override
    public void setTv(ITV tv) {
        this.tv = tv;
    }
}
















