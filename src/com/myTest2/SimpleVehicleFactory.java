package com.myTest2;

/**
 * 简单工厂
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        return new Car();
    }

    public Plane createPlane(){
        return new Plane();
    }
}
