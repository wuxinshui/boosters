package org.wuxinshui.boosters.designPatterns.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class MyBridge extends Bridge {
    public void method(){
        getSourceable().method();
    }
}
