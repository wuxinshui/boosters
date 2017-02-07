package org.wuxinshui.boosters.designPatterns.factorymethod;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/31
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is mail sender from factory method");
    }
}
