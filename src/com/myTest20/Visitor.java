package com.myTest20;


import java.util.LinkedList;
import java.util.List;

/**
 * 访问者模式基本介绍
 * 1、访问者模式（Visitor pattern），封装一些用于某种数据结构的各元素的操作，它可以在不改变数据结构的前提下定义作用这些元素的新的操作
 *    它可以在不改变数据结构的前提下定义作用于这些元素的新的操作
 * 2、主要将数据结构与数据操作分离，解决数据结构和操作耦合性问题
 * 3、访问者模式的基本工作原理是：在被访问的类里面加一个 对外提供接待访问者的接口
 * 4、访问者模式主要应用场景是：需要对一个对象结构中的对象进行很多不同操作（这些操作彼此之间没有关联），同时需要避免让这些操作“污染”这
 *    些对象的类，可以选用访问者模式解决
 */

/**
 * 访问者模式的注意事项和细节
 * 1、访问者模式符合单一职责原则、让程序具有优秀的扩展性、灵活性非常高
 * 2、访问者模式可以对功能进行统一，可以做报表、ui、拦截器与过滤器，适用于数据结构相对稳定的系统
 *
 * 缺点：
 * 1、具体元素对访问者公布细节，也就是说访问者关注了其他类的内部细节，这是迪米特法则所不建议的，这样造成了具体元素变更比较困难
 * 2、违背了依赖倒转原则，访问者依赖的是具体元素，不是抽象元素
 * 3、因此，如果一个系统有比较稳定的数据结构，又有经常变化的功能需求，那么访问者模式就是比较合适的
 */
public class Visitor {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Women());

        // 成功
        Success success = new Success();
        objectStructure.display(success);
    }
}

abstract class Action{
    // 得到男性的测评
    public abstract void getManResult(Man man);

    // 得到女性的测评
    public abstract void getWomenResult(Women women);
}

abstract class Person{
    public abstract void accept(Action action);
}

class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}

//1. 这里使用到了双分派,即首先在客户端程序中,将具体状态作为参数传递Woman中(第一次分派)
//2. 然后Woman类调用作为参数的"具体方法"中方法getWomanResult,同时将自己(this)作为参数传入,完成第二次的分派
class Women extends Person{

    @Override
    public void accept(Action action) {
        action.getWomenResult(this);
    }
}


class Success extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男性评价----成功");
    }

    @Override
    public void getWomenResult(Women women) {
        System.out.println("女性评价----成功");
    }
}


class Fail extends Action{

    @Override
    public void getManResult(Man man) {
        System.out.println("男性评价----失败");
    }

    @Override
    public void getWomenResult(Women women) {
        System.out.println("女性评价----失败");
    }
}
class ObjectStructure{
    private List<Person> persons = new LinkedList<>();

    // 增加到list
    public void attach(Person p){
        persons.add(p);
    }

    // 移除
    public void detach(Person p){
        persons.remove(p);
    }

    public void display(Action action){
        for (Person p : persons) {
            p.accept(action);
        }
    }
}





