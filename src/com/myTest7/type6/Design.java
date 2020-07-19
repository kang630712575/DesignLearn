package DesignLearn.src.com.myTest7.type6;

/**
 * 单例模式(枚举)
 * 优缺点：
 * 1、这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建一个新的对象
 * 2、这种方式是effective java作者josh bloch 提倡的方式
 * 3、结论：推荐使用
 */
public class Design {
    Singleton singleton1 = Singleton.Instance;
    Singleton singleton2 = Singleton.Instance;
}

enum Singleton{
    Instance;
    public void sayOk(){
        System.out.println("ok~");
    }
}

/**
 * 单例模式jdk应用源码分析：
 * 1、jdk中，java.lang.Runtime就是经典的单例模式
 */

/**
 * 单例模式注意事项：
 * 1、单例模式保证了系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，使用单例模式可以提高系统性能
 * 2、当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new
 * 3、单例模式使用的场景：需要频繁的进行创建和销毁的对象、创建对象时耗时过多或耗费资源过多(即：重量级对象)，但又经常用到的对象、
 *    工具类对象、频繁访问数据库或文件的对象(比如数据源、session工厂等)
 */
