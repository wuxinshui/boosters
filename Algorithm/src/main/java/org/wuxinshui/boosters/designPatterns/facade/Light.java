package org.wuxinshui.boosters.designPatterns.facade;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/16
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class Light {
    public void on() {
        System.out.println("正在开灯。。。");
    }

    public void off() {
        System.out.println("正在关灯。。。");
    }
}
