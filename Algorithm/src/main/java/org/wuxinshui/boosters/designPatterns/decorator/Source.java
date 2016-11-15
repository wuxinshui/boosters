package org.wuxinshui.boosters.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/15
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class Source implements Sourceable
{

    @Override
    public void print() {
        System.out.println("This is original!");
    }
}
