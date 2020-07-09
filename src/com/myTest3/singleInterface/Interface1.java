package com.myTest3.singleInterface;

// 接口隔离原则（Interface Segregation Principle）
class E{
    public static void main(String[] args) {
        A a = new A();
        a.dependent1(new B());
        a.dependent2(new B());
        a.dependent3(new B());

        C c = new C();
        c.dependent1(new D());
        c.dependent2(new D());
        c.dependent3(new D());
    }
}
// 接口1
interface Interface1 {
    void operation1();
}

// 接口2
interface Interface2 {
    void operation2();
    void operation3();
}

// 接口3
interface Interface3 {
    void operation4();
    void operation5();
}

class B implements Interface1, Interface2 {

    @Override
    public void operation1() {
        System.out.println("B执行了方法1...");
    }

    @Override
    public void operation2() {
        System.out.println("B执行了方法2...");
    }

    @Override
    public void operation3() {
        System.out.println("B执行了方法3...");
    }
}

class D implements Interface1,Interface3{

    @Override
    public void operation1() {
        System.out.println("D执行了方法1...");
    }

    @Override
    public void operation4() {
        System.out.println("D执行了方法4...");
    }

    @Override
    public void operation5() {
        System.out.println("D执行了方法5...");
    }
}

class A{

    void dependent1(Interface1 i){
        i.operation1();
    }

    void dependent2(Interface2 i){
        i.operation2();
    }

    void dependent3(Interface2 i){
        i.operation3();
    }
}

class C{
    void dependent1(Interface1 i){
        i.operation1();
    }
    void dependent2(Interface3 i){
        i.operation4();
    }
    void dependent3(Interface3 i){
        i.operation5();
    }
}
