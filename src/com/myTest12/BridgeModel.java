package com.myTest12;


/**
 * 桥接模式
 * 1、传统方案解决手机操作问题分析
 * 1）扩展性问题(类爆炸)，如果我们再增加手机的样式(旋转式)，就需要增加各个品牌手机的类，同样如果我们增加一个手机品牌，也要在各个手机样式
 *    类下增加
 * 2）违反了单一职责原则，当我们增加手机样式时，要同时增加所有品牌的手机，这样增加了代码维护成本
 * 3）解决方案-使用桥接模式
 */

/**
 * 基本介绍：
 * 1、桥接模式(Bridge模式)：将实现与抽象放在两个不同的类层次中，使两个层次可以独立改变
 * 2、是一种结构型设计模式
 * 3、Bridge模式基于类的最小设计原则，通过使用封装、聚合及继承等行为让不同的类承担不同的职责。他的主要特点是把抽象（Abstraction）与行为
 *    实现（implement）分离开来，从而可以保持各部分的独立性以及应对他们的功能扩展
 */

/**
 * 注意事项：
 * 1、实现了抽象和实现部分的分离，从而极大的提供了系统的灵活性，让抽象部分和实现部分独立开来，这有助于系统进行分层设计，从而产生更好的结构
 *    化系统。
 * 2、对于系统的高层部分，只需要知道抽象部分和实现部分的接口就可以了，其他的部分由具体业务来完成
 * 3、桥接模式替代多层继承方案，可以减少子类的个数，降低系统的管理和维护成本
 * 4、桥接模式的引入增加了系统的理解和设计难度，由于聚合关联关系建立在抽象曾，要求开发者针对抽象进行设计和变成
 * 5、桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围有一定的局限性，即需要有这样的应用场景
 */

/**
 * 其他应用场景
 * 1、对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用
 * 2、常见的应用场景
 *    *-JDBC驱动程序
 *    *-银行转账系统
 *    转账分类：网上转账，柜台转账，AMT转账
 *    转账用户类型：普通用户，银卡用户，金卡用户
 *    *-消息管理
 *    消息类型：即时消息，延时消息
 *    消息分类：手机短信，邮件消息，QQ消息
 */
public class BridgeModel {
    public static void main(String[] args) {
        Phone phone = new FoldedPhone(new XiaoMi());
        phone.call();
        phone.close();
        phone.open();
    }
}

interface Brand{
    void open();
    void close();
    void call();
}

class XiaoMi implements Brand{

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }
}

class ViVo implements Brand{

    @Override
    public void open() {
        System.out.println("vivo手机开机");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关机");
    }

    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}

abstract class  Phone{
    // 组合品牌
    private Brand brand;
    //构造器
    public Phone(Brand brand){
        super();
        this.brand = brand;
    }
    protected void open(){
        this.brand.open();
    }
    protected void close(){
        brand.close();
    }
    protected void call(){
        brand.call();
    }
}

class FoldedPhone extends Phone{

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open(){
        super.open();
        System.out.println("折叠样式手机");
    }

    public void close(){
        super.close();
        System.out.println("折叠样式手机");
    }

    public void call(){
        super.call();
        System.out.println("折叠样式手机");
    }
}
































