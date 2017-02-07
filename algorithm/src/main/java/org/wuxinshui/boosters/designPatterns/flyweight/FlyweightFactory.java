package org.wuxinshui.boosters.designPatterns.flyweight;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/16
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class FlyweightFactory {
    private HashMap<String,Shape> flyweights=new HashMap<>();

    public Shape getShape(String key){
        Shape shape=flyweights.get(key);
        if (null==shape){
            shape=new Circle(key);
            flyweights.put(key,shape);
        }
        return shape;
    }

    public int getSums(){
        return flyweights.size();
    }



    public HashMap<String, Shape> getFlyweights() {
        return flyweights;
    }

    public void setFlyweights(HashMap<String, Shape> flyweights) {
        this.flyweights = flyweights;
    }
}
