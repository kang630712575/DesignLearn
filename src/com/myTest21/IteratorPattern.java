package com.myTest21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器模式基本介绍
 * 1、迭代器模式(iterator pattern):是常用的设计模式，属于行为型模式
 * 2、如果我们的集合元素是用不同的方式实现的，有数组，还有java的集合类，或者还有其他方式，当客户端要遍历这些集合元素的时候，就要使用多
 *    种遍历方式，而且还会暴露元素的内部结构，可以考虑使用迭代器模式解决
 * 3、迭代器模式，提供一种遍历集合元素的统一接口，用一致的方法遍历集合元素，而不需要知道集合对象的底层表示，即：不暴露其内部结构
 */

/**
 * 迭代器模式的注意事项和细节
 * 优点：
 * 1、提供一个统一的方法遍历对象，客户不用再考虑聚合的类型，使用一种方法就可以遍历对象了。
 * 2、隐藏了聚合的内部结构，客户端要遍历聚合的时候只能取到迭代器，而不会知道聚合的具体组成
 * 3、提供了一种设计思想，就是一个类应该只有一个引起变化的原因(叫做单一责任原则)。在聚合类中，我们把迭代器分开，就是要把管理对象集合和
 *    遍历对象集合的责任分开，这样一来集合改变的话，之影响到聚合对象，而如果遍历方式改变的话，只影响到了迭代器
 * 4、当要展示一组相似对象，或者遍历一组相同对象时使用，适合使用迭代器模式
 * 缺点：
 * 1、每个聚合对象都要一个迭代器，会生成多个迭代器不好管理类
 */



public class IteratorPattern {
}


class Department{
    private String name;
    private String desc;

    public Department(String name, String desc) {
        super();
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

class ComputerCollegeIterator implements Iterator {

    Department[] departments;

    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        super();
        this.departments = departments;
    }

    // 判断是否还有下一个
    @Override
    public boolean hasNext() {
        if(position >= departments.length || departments[position] == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position += 1;
        return department;
    }

    // 删除方法默认空实现
    public void remove(){

    }
}


class InfoCollegeIterator implements Iterator{

    List<Department> departmentList;
    int index = -1;

    public InfoCollegeIterator(List<Department> departmentList) {
        super();
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if(index >= departmentList.size()){
            return false;
        }else{
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    public void remove(){

    }
}




interface College{
    public String getName();

    public void addDepartment(String name,String desc);

    public Iterator createIterator();
}

class ComputerCollege implements College{

    Department[] departments;
    int numOfDepartment = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("java专业","Java专业");
        addDepartment("php专业","php专业");
        addDepartment("大数据专业","大数据专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {

        Department department = new Department(name,desc);
        departments[numOfDepartment] = department;
        numOfDepartment += 1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}

class InfoCollege implements College{

    List<Department> departmentList;
    public InfoCollege(){
        departmentList = new ArrayList<Department>();
        addDepartment("信息安全专业","信息安全专业");
        addDepartment("网络安全专业","网络安全专业");
        addDepartment("工程安全专业","工程安全专业");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name,desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}

class OutPutImpl{
    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege(){
        // java中list已经实现了iterator方法
        Iterator<College> iterator = collegeList.iterator();

        while (iterator.hasNext()){
            College college = iterator.next();
            System.out.println("===============" + college.getName() +"=================");
            printDepartment(college.createIterator());
        }
    }

    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
}


class Client{

    public static void main(String[] args) {
        ArrayList<College> collegeArrayList = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        collegeArrayList.add(computerCollege);
        collegeArrayList.add(infoCollege);

        OutPutImpl outPut = new OutPutImpl(collegeArrayList);
        outPut.printCollege();
    }
}


















