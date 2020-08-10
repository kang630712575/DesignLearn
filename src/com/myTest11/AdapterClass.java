package com.myTest11;

/**
 * 适配器模式介绍
 * 1、适配器模式(Adapter Pattern)将某个类的接口转换成客户端期望的另一个接口表示，主要目的是兼容性，让原本因接口不匹配不能一起工作
 *    的两个类可以协同工作。其别名为包装器(Wrapper)
 * 2、适配器模式数据结构性模式
 * 3、主要分为三类：类适配器模式、对象适配器模式、接口适配器模式
 */
public class AdapterClass {

}

class Voltage220V{
    public int output220V(){
        int src = 220;
        System.out.println("电压" + src + "V");
        return src;
    }
}

interface Voltage5V{
    public int output5V();
}


// 类适配器
class VoltageAdapter extends Voltage220V implements Voltage5V{

    @Override
    public int output5V() {
        // 获取到220V电压
        int srcV = output220V();
        int dstV = srcV / 44;
        return dstV;
    }
}

class Phone{
    //
}











