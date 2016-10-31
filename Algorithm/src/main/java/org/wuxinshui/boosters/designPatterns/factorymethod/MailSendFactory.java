package org.wuxinshui.boosters.designPatterns.factorymethod;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/31
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public class MailSendFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
