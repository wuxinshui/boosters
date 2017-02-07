package org.wuxinshui.boosters.designPatterns.facade;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/16
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 * <p>
 * 外观模式就是提供一个统一的接口，用来访问子系统中的一群接口。
 */
public class WatchTVSwitchFacade {
    private Television tv;
    private Light light;
    private Screen screen;
    private AirCondition air;

    public WatchTVSwitchFacade(Television tv, Light light, Screen screen, AirCondition air) {
        this.tv = tv;
        this.light = light;
        this.screen = screen;
        this.air = air;
    }

    public void on() {
        System.out.println("正在启动电器。。。");
        tv.on();
        light.on();
        screen.down();
        air.on();
    }

    public void off() {
        System.out.println("正在关闭电器。。。");
        tv.off();
        light.off();
        screen.up();
        air.off();
    }

}
