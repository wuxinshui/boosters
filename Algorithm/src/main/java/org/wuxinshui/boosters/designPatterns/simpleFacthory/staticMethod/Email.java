package org.wuxinshui.boosters.designPatterns.simpleFacthory.staticMethod;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/30
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
public class Email implements Sender {
    @Override
    public void send() {
        System.out.println("This is email from static method!");
    }
}
