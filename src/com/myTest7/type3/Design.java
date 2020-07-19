package DesignLearn.src.com.myTest7.type3;

/**
 * 懒汉式优缺点说明(线程不安全)
 * 1、起到了Lazy Loading的效果，但是只能在单线程下使用
 * 2、如果在多线程下，一个线程进入了if(singleton == null)判断语句块，还未来的及往下执行，另一个线程也通过这个判断语句，这时便会
 *    产生多个实例，所以在多线程环境下不可使用这种方式
 * 3、结论：在实际开发中，不要使用这种方式。
 */
public class Design {

}

class Singleton{
    private static Singleton instance;

    private Singleton(){}

    // 提供一个静态的公有方法，当使用到该方法时，才去创建instance
    // 即懒汉式
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

// 懒汉式(线程安全)

/**
 * 优缺点：
 * 1、解决了线程不安全问题
 * 2、效率太低了，每个线程在想要获得类的实例的时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，
 *    后面的想获得该类实例，直接return就行了，方法进行同步效率太低。
 * 3、结论：在实际开发中，不推荐使用这种方式
 */
class Singleton2{
    private static Singleton2 instance;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(instance == null)
        instance = new Singleton2();
        return instance;
    }

}