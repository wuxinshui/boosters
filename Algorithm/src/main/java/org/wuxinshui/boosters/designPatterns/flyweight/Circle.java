package org.wuxinshui.boosters.designPatterns.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/17
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
public class Circle extends Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("画了个圆，颜色是："+color);
    }
}
