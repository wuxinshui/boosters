package org.wuxinshui.boosters.designPatterns.simpleFacthory.normal;

/**
 * Created by FujiRen on 2016/10/28.
 */
public class Sms implements Sender {
    @Override
    public void send() {
        System.out.println("This is sms!");
    }
}
