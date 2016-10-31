package org.wuxinshui.boosters.designPatterns.factorymethod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/31
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class MailSendFactoryTest {
    @Test
    public void produce() throws Exception {
        Sender sender=new MailSendFactory().produce();
        sender.send();
    }

}