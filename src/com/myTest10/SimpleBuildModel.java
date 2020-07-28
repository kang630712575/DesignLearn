package com.myTest10;


/**
 * 传统方式解决盖房需求问题分析
 * 1、优点是比较好理解，简单易操作
 * 2、设计的程序结构过于简单，没有设计缓存层对象，程序的扩展和维护不好，也就是说，这种设计方案，把产品(即：房子)和创建产品的过程
 *    (即：建房子流程)封装再一起，耦合性增强了
 * 3、解决方案：将产品和产品建造过程解耦 => 建造者模式
 */
public class SimpleBuildModel {
}

abstract class AbstractHouse{
    // 打地基
    public abstract void buildBasic();
    // 砌墙
    public abstract void buildWalls();
    // 封顶
    public abstract void roofed();

    public void build(){
        buildBasic();
        buildWalls();
        roofed();
    }
}


class CommonHose extends AbstractHouse{

    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}

class Client{
    public static void main(String[] args) {
        CommonHose commonHose = new CommonHose();
        commonHose.build();
    }
}













