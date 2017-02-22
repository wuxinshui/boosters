package org.wuxinshui.boosters.designPatterns.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: wuxinshui
 * Date: 2016/11/17
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory=new FlyweightFactory();
        Shape shape=factory.getCircle("灰色");
        shape.draw();
        Shape shape3=factory.getCircle("黄色");
        shape3.draw();
        Shape shape1=factory.getCircle("灰色");
        shape1.draw();
        Shape shape2=factory.getCircle("黄色");
        shape2.draw();

        System.out.println("有 "+factory.getCircleSum()+" 种颜色的圆");

        Shape rectangel=factory.getRectangle("0",12,25);
        rectangel.draw();
        Shape rectange2=factory.getRectangle("0",14,12);
        rectange2.draw();
        Shape rectangle3=factory.getRectangle("1",23,23);
        rectangle3.draw();

        System.out.println("画了 "+factory.getRectangleSum()+" 种矩形");

    }
}
