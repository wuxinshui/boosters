package org.wuxinshui.boosters.designPatterns.simpleFacthory.moreMethods;

/**
 * Created by FujiRen on 2016/10/30.
 */
public class Email implements Sender {
    @Override
    public void send() {
        System.out.println("This is Email from More Methods");
    }
}
