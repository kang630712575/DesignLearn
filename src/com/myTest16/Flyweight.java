package com.myTest16;


/**
 * 享元模式基本介绍
 * 1、享元模式(Flyweight pattern)也叫蝇量模式：运用共享技术有效的支持大量细粒度的对象
 * 2、常用于系统底层开发，解决系统的性能问题。像数据库连接池，里面都是创建好的连接对象，在这些连接对象中有我们需要的则直接拿来用，避免
 *    重新创建，如果没有我们需要的，则创建一个
 * 3、享元模式能够解决重复对象的内存浪费问题，当系统中有大量相似对象，需要缓冲池时，不需总是创新对象，可以从缓冲池里拿。这样可以降低系统内存
 *    ，同时提高效率
 * 4、享元模式经典的应用场景就是池技术了，String常量池、数据库连接池、缓冲池等等都是享元模式的应用，享元模式是池技术的重要实现方式
 */

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * 内部状态和外部状态
 * 1、享元模式提出了两个要求：细粒度和共享对象。这里涉及到内部状态和外部状态了，即将对象的信息分为两个部分：内部状态和外部状态
 * 2、内部状态指对象共享出来的信息，存储在享元对象内部且不会随环境的改变而改变
 * 3、外部状态指对象得以依赖的一个标记，是随环境改变而改变的、不可共享的状态
 */

/**
 * 享元模式的注意事项和细节
 * 1、在享元模式这样理解，“享”就表示共享，“元”表示对象
 * 2、系统中有大量对象，这些对象消耗大量内存。并且对象的状态大部分可以外部化时，我们就可以考虑选用享元模式
 * 3、用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象，用HashMap/HashTable存储
 * 4、享元模式大大减少了对象的创建，降低了程序内存的占用，提高效率
 * 5、享元模式提高了系统的复杂度，需要分离出内部状态和外部状态，而外部状态具有固化特性，不应该随着内部状态的改变而改变，这是我们使用
 *    享元模式需要注意的地方
 * 6、使用享元模式时，注意划分内部状态和外部状态，并且需要有一个工厂类加以控制
 * 7、享元模式经典的应用场景时需要缓冲池的场景，比如String常量池、数据库连接池
 */
public class Flyweight {

    public static void main(String[] args) {
        // 创建一个工厂
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        // 客户要一个以新闻形式发布的网站
        WebSite webSite1 = webSiteFactory.getWebSite("新闻");
        webSite1.use(new User("tom"));
    }
}

abstract class WebSite{
    public abstract void use(User user);
}


class ConcreteWebSite extends WebSite{

    // 共享的部分，内部状态
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网站的发布形式为:"+ type + "在使用。。。");
    }
}


class WebSiteFactory{

    // 集合，充当池的作用
    private HashMap<String,ConcreteWebSite> pool = new HashMap<>();

    // 根据网站的类型，返回一个网站，如果没有就创建一个网站，并放入到池中
    public WebSite getWebSite(String type){
        if(pool.containsKey(type)){
            // 创建一个放入池中
            pool.put(type,new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }

    // 获取网站分类的总数（池中有多少个网站类型）
    public int getWebSiteSize(){
        return pool.size();
    }


}


class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}





















