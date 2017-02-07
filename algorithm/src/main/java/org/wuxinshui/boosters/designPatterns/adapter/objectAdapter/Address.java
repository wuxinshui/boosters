package org.wuxinshui.boosters.designPatterns.adapter.objectAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/7
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public class Address {
    public void street(){
        System.out.println("Adaptee:This is Address street");
    }

    public void zip(){
        System.out.println("Adaptee:This is Address zip");
    }

    public void city(){
        System.out.println("Adaptee:This is Address city");
    }
}
