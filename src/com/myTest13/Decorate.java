package com.myTest13;

/**
 * 装饰者模式
 * 1、装饰者模式：动态的将新功能附加到对象上。在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了开闭原则(ocp)
 */
public class Decorate extends Drink{

    private Drink obj;

    public Decorate(Drink obj){
        this.obj = obj;
    }

    @Override
    public float cast() {
        return super.getPrice() + obj.cast();
    }

    @Override
    public String getDes(){
        return super.des + " " + super.getPrice() + " && " + obj.getDes();
    }
}

abstract class Drink{
    public String des; // 描述
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // 费用的抽象方法
    public abstract float cast();
}


class Chocolate extends Decorate{

    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);
    }
}

class Milk extends Decorate{

    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(3.0f);
    }
}

class Soy extends Decorate{

    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(3.0f);
    }
}


















