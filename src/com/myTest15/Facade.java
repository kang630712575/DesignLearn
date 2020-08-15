package com.myTest15;

/**
 * 外观模式基本介绍
 * 1、外观模式(facade)，也叫过程模式：外观模式为子系统中的以组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加
 *    容易使用
 * 2、外观模式通过定义一个一致的接口，用以屏蔽内部子系统的细节，使得调用端只需跟这个接口发生调用，而无需关心这个子系统的内部细节。
 */

/**
 * 外观模式的注意事项和细节
 * 1、外观模式对外屏蔽了子系统的细节，因此外观模式降低了客户端对子系统使用的复杂性
 * 2、外观模式对客户端与子系统的耦合关系，让子系统内部的模块更易维护和扩展
 * 3、通过合理的使用外观模式，可以帮我们更好的划分访问层次
 * 4、当系统需要进行分层设计时，可以考虑使用Facade模式
 * 5、在维护一个遗留的大型系统时，可能这个系统已经变得非常难以维护和扩展，此时可以考虑为新系统开发一个Facade类，来提供遗留系统的比较清晰
 *    简单的接口，让新系统与Facade类交互，提高复用性
 * 6、不能过多的或者不合理的使用外观模式，使用外观模式好，还是直接调用模块好，要以让系统有层次，利于维护为目的
 */
public class Facade {
}

class DVDPlayer{

    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("DVD on");
    }

    public void off(){
        System.out.println("DVD off");
    }

    public void play(){
        System.out.println("DVD is playing");
    }
}

class Popcorn{
    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on(){
        System.out.println("popcorn on");
    }

    public void off(){
        System.out.println("popcorn off");
    }

    public void pop(){
        System.out.println("popcorn pop");
    }
}

class Projector{
    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on(){
        System.out.println("Projector on");
    }

    public void off(){
        System.out.println("Projector off");
    }

    public void focus(){
        System.out.println("Projector focus");
    }
}


class Screen{
    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up(){
        System.out.println("Screen on");
    }

    public void down(){
        System.out.println("Screen off");
    }
}

class Stereo{
    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    public void on(){
        System.out.println("Stereo on");
    }

    public void off(){
        System.out.println("Stereo off");
    }
}

class HomeTheaterFacade{
    // 定义各个子系统对象
    private Popcorn popcorn;
    private Stereo stereo;
    private Projector projector;
    private Screen screen;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade() {
        super();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    // 操作分4步
    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        dvdPlayer.on();
    }

    public void play(){
        dvdPlayer.play();
    }


    public static void main(String[] args) {

    }
}











