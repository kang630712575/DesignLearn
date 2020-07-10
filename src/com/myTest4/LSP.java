package com.myTest4;

/**
 * 里氏替换原则(Liskov Substitution Principle)
 * 1.如果对每个类型为T1的对象o1，都有类型为T2的对象o2，使得以T1定义的所有程序P在所有的对象o1都换成o2时，程序P的行为没有发生变化
 * 那么类型T2是类型T1的子类型，换句话说，所有引用基类的地方必须能透明的使用其子类的对象
 * 2.在使用继承时，遵循里氏替换原则，在子类中尽量不要重写父类的方法
 * 3.里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当的情况下，可以通过聚合，组合，依赖来解决问题
 */
public class LSP {
    public static void main(String[] args) {
        B b = new B();
        System.out.println("b.function3(1,2)="+b.function3(1,2));
    }
}


class A extends LSP{
    int function1(int a,int b){
        return a*b;
    }
}

class B extends LSP{
    A a = new A();
    int function1(int a,int b){
        return a-b;
    }

    int function2(int a,int b){
        return a*b;
    }

    int function3(int a,int b){
        return this.a.function1(a,b);
    }
}