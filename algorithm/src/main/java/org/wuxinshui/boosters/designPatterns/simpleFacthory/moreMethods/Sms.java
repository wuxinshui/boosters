package org.wuxinshui.boosters.designPatterns.simpleFacthory.moreMethods;

/**
 * Created by FujiRen on 2016/10/30.
 */
public class Sms implements Sender {
    @Override
    public void send() {
        System.out.println("This is SMS from MORE METHODS");
    }
}
