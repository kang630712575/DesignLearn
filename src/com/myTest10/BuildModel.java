package com.myTest10;

/**
 * 建造者模式基本介绍：
 * 1、建造者模式又叫生成器模式，是一种对象构建模式。它可以将复杂对象的建造过程抽象出来(抽象类别)，使这个抽象过程的不同实现方法可以构造出
 *    不同表现(属性)的对象。
 * 2、建造者模式使一步步创建一个复杂的对象，它允许用户只通过指定复杂对象的类型和内容就可以构建他们，用户不需要知道内部的具体构建细节
 */

/**
 * 建造者模式的四个角色：
 * 1、Product(产品角色)：一个具体的产品对象
 * 2、Builder(抽象建造者)：创建一个Product对象的各个部件指定的接口/抽象类
 * 3、ConcreteBuilder(具体建造者)：实现接口，构建和装配各个部件
 * 4、Director(指挥者)：构建一个使用builder接口的对象。他主要是用于创建一个复杂的对象，它主要有两个作用：①隔离了客户与对象的生产过程
 *                     ②负责控制产品对象的生产过程
 */

/**
 * 建造者模式在jdk的应用和源码分析
 * 1、Appendable接口定义了多个append方法(抽象方法)，即Appendable为抽象建造者，定义了抽象方法
 * 2、AbstractStringBuilder实现了Appendable接口方法，这里的AbstractStringBuilder已经是建造者了，只是不能实例化
 * 3、StringBuilder即充当了指挥者角色，同时充当了具体的建造者，建造方法的实现是由AbstractStringBuilder完成，而StringBuilder
 *    继承了AbstractStringBuilder
 */
public class BuildModel {

    public static void main(String[] args) {
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        // 完成房子
        House house = houseDirector.constructorHouse();

        System.out.println("输出流程");
    }
}

class House{
    private String baise;
    private String wall;
    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
// 抽象建造者
abstract class HouseBuilder{
    protected House house = new House();

    // 将建造流程写好
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    // 建造好后将产品返回
    public House buildHouse(){
        return house;
    }
}

class CommonHouse extends HouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("普通房子地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子刷墙2平米");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子房顶5米");
    }
}

class HighBuilding extends HouseBuilder{

    @Override
    public void buildBasic() {
        System.out.println("高楼地基10米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼屋顶5米");
    }
}

// 指挥者  动态指定制作流程，返回产品
class HouseDirector{
    HouseBuilder houseBuilder = null;

    // 构造器传入houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 通过setter 传入houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程，交给指挥者
    public House constructorHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}











