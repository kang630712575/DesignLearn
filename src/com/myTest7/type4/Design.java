package DesignLearn.src.com.myTest7.type4;

/**
 * 优缺点说明：
 * 1、Double-Check概念是多线程开发中经常使用的，如代码所示，进行了两次if(singleton == null)，这样就可以保证线程安全了
 * 2、这样实例化代码只用执行一次，后面再次访问时，判断if(singleton == null)，直接return实例化对象，也避免反复进行方法同步。
 * 3、线程安全；延迟加载；效率较高
 * 4、结论：在实际开发过程中，推荐使用这种单例设计模式
 */
public class Design {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton1 == singleton2);
    }

}

class Singleton{
    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (singleton){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
