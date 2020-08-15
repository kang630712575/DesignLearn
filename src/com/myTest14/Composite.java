package com.myTest14;

/**
 * 组合模式基本介绍
 * 1、组合模式(Composite Pattern)，又叫部分整体模式，他创建了对象组的树形结构，将对象组合成树状结构以表示"整体-部分"的层次关系
 * 2、组合模式依据树形结构来组合对象，用来表示部分以及整体层次
 * 3、这种类型的设计模式属于结构型模式
 * 4、组合模式使得用户对单个对象的访问具有一致性，即：组合能让客户以一致的方式处理个别对象以及组合对象
 */

/**
 * 对原理结构图的输命-即(组合模式的角色及职责)
 * 1、Component：这是组合中对象声明接口，在适当情况下，实现所有类共有的接口默认行为，用于访问和管理Component子部件，Component可以是
 *   抽象类或接口
 * 2、Leaf：在组合中表示叶子节点，叶子节点没有子节点
 * 3、Composite：非叶子节点，用于存储子部件，在Component接口中实现子部件的相关操作，比如增加(add)、删除....
 */


import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决的问题
 * 1、组合模式解决这样的问题，当我们的要处理的对象可以生成一颗树形结构，而我们要对树上的节点和叶子进行操作时，它能够提供一致的方式。而
 *   不用考虑他是节点还是叶子
 */
public class Composite {

    public static void main(String[] args) {
        // 创建学校
        OrganizationComponent university = new University("清华大学","中国顶级大学");

        // 创建学院
        OrganizationComponent computerCollege = new College("计算机学院","计算机学院");
        OrganizationComponent infoEngineerCollege = new College("信息工程学院","信息工程学院");

        // 创建各个学院下面的系(专业)
        computerCollege.add(new Department("软件工程","软件工程不错"));
        computerCollege.add(new Department("网络工程","网络工程不错"));
        computerCollege.add(new Department("计算机科学与技术","计算机科学与技术是老牌专业"));

        infoEngineerCollege.add(new Department("通信工程","通信工程不好学"));
        infoEngineerCollege.add(new Department("信息工程","信息工程不好学"));

        // 将学院加入到学校
        university.add(computerCollege);
        university.add(infoEngineerCollege);
    }
}

abstract class OrganizationComponent{
    private String name;
    private String des;

    protected void add(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }
    protected void remove(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    public OrganizationComponent(String name, String des) {
        super();
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    // 方法 print，做成抽象的
    protected abstract void print();
}


// 就是composite
class University extends OrganizationComponent{

    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    // 构造器
    public University(String name,String des){
        super(name,des);
    }

    // 重写add
    @Override
    protected void add(OrganizationComponent organizationComponent){
        organizationComponents.add(organizationComponent);
    }

    // 重写remove
    @Override
    protected void remove(OrganizationComponent organizationComponent){
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // 输出University包含的学院
    @Override
    protected void print() {
        System.out.println("===============" +getName() + "================");
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}

class College extends OrganizationComponent{

    // 存放的是department
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

    // 构造器
    public College(String name,String des){
        super(name,des);
    }

    // 重写add
    @Override
    protected void add(OrganizationComponent organizationComponent){
        organizationComponents.add(organizationComponent);
    }

    // 重写remove
    @Override
    protected void remove(OrganizationComponent organizationComponent){
        organizationComponents.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // 输出University包含的学院
    @Override
    protected void print() {
        System.out.println("===============" +getName() + "================");
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
}

class Department extends OrganizationComponent{

    // 构造器
    public Department(String name,String des){
        super(name,des);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    // 输出University包含的学院
    @Override
    protected void print() {
        System.out.println("===============" +getName() + "================");
    }
}


















