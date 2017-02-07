package org.wuxinshui.boosters.designPatterns.facade;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/16
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class Television {
    public void on() {
        System.out.println("正在打开电视。。。");
    }

    public void off() {
        System.out.println("正在关闭电视。。。");
    }
}
