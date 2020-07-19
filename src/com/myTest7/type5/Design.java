package DesignLearn.src.com.myTest7.type5;

/**
 * 单例模式(静态内部类)
 * 1、这种方式采用了类装载机制来保证初始化实例时只有一个线程。
 * 2、静态内部类方法在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，
 *    从而完成Singleton的实例化。
 * 3、类的静态属性只会在第一次加载的时候初始化，所以在这里，jvm帮助我们保证了线程安全，在类进行初始化时，别的线程是无法进入的
 * 4、优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高
 * 5、结论：推荐使用
 */

public class Design {
}

class Singleton{
    private Singleton(){}

    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
