package org.wuxinshui.boosters.designPatterns.state;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 *
 * 状态核心类
 * 核心思想就是：当对象的状态改变时，同时改变其行为
 */
public class State {
    private String state;

    public void method1(){
        System.out.println("This is method1");
    }

    public void method2(){
        System.out.println("This is method2");
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
