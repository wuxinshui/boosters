package org.wuxinshui.boosters.designPatterns.flyweight;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: wuxinshui
 * Date: 2016/11/16
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class FlyweightFactory {
    private HashMap<String,Shape> circles=new HashMap<>();
    private HashMap<String ,Shape> rectangles=new HashMap<>();

    public Shape getCircle(String key){
        Shape circle=circles.get(key);
        if (null==circle){
            circle=new Circle(key);
            circles.put(key,circle);
        }
        return circle;
    }

    public Shape getRectangle(String key,int x,int y){
        Shape rectangle=rectangles.get(key);
        if (null==rectangle){
            rectangle=new Rectangle(x,y);
            rectangles.put(key,rectangle);
        }
        return rectangle;
    }

    public int getCircleSum(){
        return circles.size();
    }
    public int getRectangleSum(){
        return rectangles.size();
    }
}
