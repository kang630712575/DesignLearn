package com.myTest18;


/**
 * 模板模式
 * 1、模板方法模式(Template Method Pattern)，又叫模板模式(Template Pattern)，在一个抽象类公开定义了执行它的方法的模板。它的子类可
 *    以按需要重写方法实现，但调用将以抽象类中定义的方式进行
 * 2、简单说，模板方法模式定义一个操作中的算法的骨架，就可以重定义该算法的某些特定的步骤
 * 3、这种类型的设计模式属于行为型模式
 */

/**
 * 模板方法模式的钩子方法:在模板方法模式的父类中,我们可以定义一个方法,它默认不做任何事,子类可以视情况要不要覆盖它,该方法称为"钩子"
 */
public class Template {
    public static void main(String[] args) {
        System.out.println("制作红豆豆浆");
        SoyaMilk redBean = new RedBean();
        redBean.make();
        System.out.println("====================================");
        System.out.println("制作花生豆浆");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();

    }
}


abstract class SoyaMilk{
    // 模板可以做成final,不让子类覆盖
    final void make(){
        select();
        addCondiments();
        soak();
        beat();
    }

    // 选材料
    void select(){
        System.out.println("第一步,选好黄豆");
    }

    // 添加不同的配料
    abstract void addCondiments();

    // 浸泡
    void soak(){
        System.out.println("第三步,泡3小时");
    }

    void beat(){
        System.out.println("第四步,打碎");
    }
}

class RedBean extends SoyaMilk{

    @Override
    void addCondiments() {
        System.out.println("第二步:加入上好的红豆");
    }
}

class PeanutSoyaMilk extends SoyaMilk{

    @Override
    void addCondiments() {
        System.out.println("第二步:加入上好的花生");
    }
}


















