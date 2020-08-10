package com.myTest11;

/**
 * 对象适配器模式介绍：
 * 1、基本思路和类的适配器模式相同，只是将Adapter类做修改，不是继承src类，而是持有src类的实例，已解决兼容性的问题。即：持有src类，
 *    实现dst类接口，完成src -> dst的适配
 * 2、根据"合成复用原则"，在系统中尽量使用关联关系来替代继承关系
 * 3、对象适配器模式是适配器模式常用的一种
 *
 *
 * 注意事项及细节
 * 1、对象适配器和类适配器其实算是同一种思想，只不过实现方式不同。根据合成复用原则，使用组合替代继承，所以它解决了适配器必须继承src
 *    的局限性问题，也不再要求dst必须是接口
 * 2、使用成本更低，更灵活
 */
public class AdapterObject {
}

class Voltage220V1{
    public int output220V(){
        int src = 220;
        System.out.println("电压" + src + "V");
        return src;
    }
}

interface Voltage5V1{
    public int output5V();
}


// 类适配器
class VoltageAdapter1 extends Voltage220V1 implements Voltage5V1{
    private Voltage220V1 voltage220V1;   // 关联关系中的聚合关系

    // 通过构造器，传入一个Voltage220V的实例
    public VoltageAdapter1(Voltage220V1 voltage220V1){
        this.voltage220V1 = voltage220V1;
    }

    @Override
    public int output5V(){
        int dst = 0;
        if(null != voltage220V1){
            int src = voltage220V1.output220V();
            System.out.println("使用对象适配器，进行适配");
            dst = src / 44;
            System.out.println("适配完成，输出的电压为=" + dst);
        }
        return dst;
    }
}


