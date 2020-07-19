package DesignLearn.src.com.myTest7;

/**
 * 设计模式：是程序员在面对同类软件工程设计问题所总结出来的有用的经验，设计模式不是代码，而是某类问题的通用解决方案，设计模式(design pattern)
 * 代表了最佳的实践。这些解决方案是众多软件开发人员经过相当长的一段时间的实验和错误总结出来的。
 *
 * 分为三种类型：
 * 1）创建型模式：单例模式、抽象工厂模式、原型模式、建造者模式、工厂模式
 * 2）结构性模式：适配器模式、桥接模式、装饰模式、组合模式、外观模式、享元模式、代理模式
 * 3）行为型模式：模板方法模式、命令模式、访问者模式、迭代器模式、观察者模式、中介者模式、备忘录模式、解释器模式(interpreter模式)、状态模式
 *              策略模式、职责链模式(责任链模式)
 */
public class Design {
}

/**
 * 单例模式：就是采用一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法(静态方法)。
 * 单例模式有8种方式：①饿汉式(静态常量)、饿汉式(静态代码块)、②懒汉式(线程不安全)、懒汉式(线程安全，同步方法)、懒汉式(线程安全、同步代码块)
 *                  ③双重检查、④静态内部类、⑤枚举
 */

/**
 * 饿汉式(静态常量)应用实例
 * 步骤：1.构造器私有化、2.类的内部创建对象、3.向外暴露一个静态的公共方法
 * 优缺点说明：
 * 1.优点：写法简单，在类加载的时候就完成实例化。避免了线程同步问题
 * 2.缺点：在类加载的时候就完成实例化，没有达到lazy loading的效果，如果从始至终从未使用过这个实例，就会造成内存的浪费。
 *        这种方式基于classloader机制避免了多线程的同步问题，不过，instance再类装载时就实例化，在单例模式中大多数是调用getInstance方法，
 *        但是，导致类装载的原因有很多种，因此不能确定有其他方式(或者其他的静态方法)导致类装载，这时候初始化instance就没有达到lazy loading
 *        的效果
 * 3.结论：这种方式可用，可能造成内存浪费
 */
class SingletonTest1{
    public static void main(String[] args) {
        //
        Singleton instance = Singleton.getInstance();
        //
        Singleton instance1 = Singleton.getInstance();
        System.out.println("对比======"+(instance == instance1));
    }
}

class Singleton{
    // 1.构造器私有化，外部不能new
    private Singleton(){

    }
    // 2.本类内部创建对象
    private final static Singleton instance = new Singleton();

    // 3.对外提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

}






















