package org.wuxinshui.boosters.designPatterns.adapter.objectAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/7
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 */
public class DutchAddress {
    public void straat(){
        System.out.println("Target:This is dutch straat!");
    }

    public void postcode(){
        System.out.println("Target:This is dutch postcode");
    }

    public void plaats(){
        System.out.println("Target:This is dutch plaats");
    }
}
