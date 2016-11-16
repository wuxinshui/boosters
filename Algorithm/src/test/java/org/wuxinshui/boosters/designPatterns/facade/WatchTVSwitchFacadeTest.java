package org.wuxinshui.boosters.designPatterns.facade;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/16
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 * 客户端
 */
public class WatchTVSwitchFacadeTest {
    Light light = new Light();
    Screen screen = new Screen();
    AirCondition ac = new AirCondition();
    Television tv = new Television();
    WatchTVSwitchFacade facade = new WatchTVSwitchFacade(tv, light, screen, ac);

    @Test
    public void on() throws Exception {
        facade.on();
    }

    @Test
    public void off() throws Exception {
        facade.off();
    }

}