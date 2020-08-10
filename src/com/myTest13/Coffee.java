package com.myTest13;

public class Coffee extends Drink{

    @Override
    public float cast() {
        return super.getPrice();
    }
}

class Espresso extends Coffee{
public Espresso(){
        setDes("意大利咖啡");
        setPrice(6.0f);

        }
        }

class LongBlack extends Coffee{
    public LongBlack(){
        setDes("LongBlack");
        setPrice(5.0f);
    }
}

class ShortBlack extends Coffee{
    public ShortBlack(){
        setDes("ShortBlack");
        setPrice(5.0f);
    }
}









