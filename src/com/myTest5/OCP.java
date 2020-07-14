package com.myTest5;

import java.awt.*;

/**
 * 开闭原则(Open Closed Principe)：编程中最基本，最重要的原则
 * 1.一个软件实体，如类，模块和函数应该对外扩展开放(对提供方)，对修改关闭(对使用方)。用抽象构建框架，用实现扩展细节
 * 2.当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化
 * 3.编程中遵循其他原则，以及使用设计模式的目的就是遵循开闭原则
 */
public class OCP {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawTools(new Rectangle());
        graphicEditor.drawTools(new Circle());
        graphicEditor.drawTools(new Triangle());
    }
}

class GraphicEditor{
    public void drawTools(Shape s){
        s.draw();
    }
}

abstract class Shape{
    int my_type;
    public abstract void draw();
}

class Rectangle extends Shape{

    Rectangle(){
        super.my_type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制方形 ");
    }
}

class Circle extends Shape{
    Circle(){
        super.my_type = 2;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

class Triangle extends Shape{

    Triangle(){
        super.my_type = 3;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}



