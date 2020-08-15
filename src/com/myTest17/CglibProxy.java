package com.myTest17;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理模式的基本介绍
 * 1、静态代理和JDK代理模式都要求目标对象是实现以一个接口，但是有时候目标对象只是一个单独的对象，并没有实现任何的接口，这个时候可以使用
 *    目标对象子类实现代理-这就是Cglib代理
 * 2、Cglib代理也叫作子类代理，他是在内存中构建一个子类对象从而实现对目标对象功能扩展，有些书也将Cglib代理归属到动态代理
 * 3、Cglib是一个强大的高性能的代码生成包，它可以在运行期扩展java类与实现java接口。它广泛的被许多AOP框架使用，例如spring AOP实现方法
 *    拦截
 * 4、在AOP编程中如何选择代理模式：
 *    1.目标对象需要实现接口，用JDK代理
 *    2.目标对象不需要实现接口，用Cglib代理
 * 5、Cglib包的底层是通过使用字节码处理框架ASM来转换字节码并生成新的类
 *
 *
 * 使用注意事项：
 * 1、在内存中动态构建子类，注意代理的类不能为final，否则报错
 * 2、目标对象的方法如果为final/static，那么就不会被拦截，即不会执行目标对象额外的业务方法
 */
public class CglibProxy {
    public static void main(String[] args) {
        TeacherDao22 teacherDao22 = new TeacherDao22();

        TeacherDao22 proxyInstance = (TeacherDao22)new ProxyFactory1(teacherDao22).getProxyInstance();

        proxyInstance.teach();
    }
}


class TeacherDao22{
    public void teach(){
        System.out.println("老师授课中，cglib，不用实现接口");
    }
}

class ProxyFactory1 implements MethodInterceptor{

    // 维护一个目标对象
    private Object target;


    public ProxyFactory1(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始......");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib代理结束......");
        return invoke;
    }
    // 返回一个代理对象 是target对象的代理对象
    public Object getProxyInstance(){
        // 创建一个工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(target.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类对象，即代理对象
        return enhancer.create();
    }
}


/**
 * 代理模式的变体
 * 1、防火墙代理：内网通过代理穿透防火墙，实现对公司内网的访问
 * 2、缓存代理：比如当请求图片文件等资源时，先到缓存代理取，如果取到资源ok，如果取不到资源，再到公网或者数据库取，然后缓存
 * 3、远程代理：远程对象的本地代表，通过它可以把远程对象当本地对象来调用，远程代理通过网络和真正的远程对象沟通信息
 * 4、同步代理：主要使用在多线程编程中，完成多线程间同步工作
 */
















