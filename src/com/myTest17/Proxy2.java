package com.myTest17;


/**
 * 代理模式的基本介绍
 * 1、代理模式：为一个对象提供一个替身，以控制对这个对象的访问。即通过代理对象访问目标对象，这样做的好处是：可以在目标对象实现的基础上
 *    增强额外的功能操作，即扩展目标对象的功能
 * 2、被代理的对象可以是远程对象、创建开销大的对象或需要安全控制的对象
 * 3、代理模式有不同的形式，主要有三种：静态代理、动态代理(JDK代理、接口代理)和Cglib代理（可以在内存中动态创建对象，而不需要实现接口属于动态代理）
 */


/**
 * 静态代码模式基本介绍
 * 静态代理在使用时，需要定义接口或者父类，被代理对象(即目标对象)与代理对象一起实现相同的接口或者是继承相同父类
 * 优点:
 *    在不修改目标对象的功能前提下,能通过代理对象对目标功能扩展
 * 缺点:
 *    因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,一旦接口增加方法,目标对象与代理对象都要维护
 */
public class Proxy2 {
}


interface ITeacher{
    void teach();
}

class TeacherDao implements ITeacher{

    @Override
    public void teach() {
        System.out.println("老师授课中。。。");
    }
}


// 代理对象，静态代理
class TeacherProxy implements ITeacher{

    private ITeacher target;

    public TeacherProxy(ITeacher target) {
        super();
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理开始。。。");
        target.teach();
        System.out.println("代理结束。。。");
    }
}

class Client{
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao teacherDao = new TeacherDao();

        // 创建代理对象,同时将被代理对象传递给代理对象
        TeacherProxy teacherProxy = new TeacherProxy(teacherDao);

        // 通过代理对象,调用到被代理对象的方法
        teacherProxy.teach();
    }

}
























