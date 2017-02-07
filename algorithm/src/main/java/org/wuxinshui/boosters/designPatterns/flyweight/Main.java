package org.wuxinshui.boosters.designPatterns.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/17
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory=new FlyweightFactory();
        Shape shape=factory.getShape("灰色");
        shape.draw();
        Shape shape3=factory.getShape("黄色");
        shape3.draw();
        Shape shape1=factory.getShape("灰色");
        shape1.draw();
        Shape shape2=factory.getShape("黄色");
        shape2.draw();
    }
}
