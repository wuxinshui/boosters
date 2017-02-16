package org.wuxinshui.boosters.designPatterns.factorymethod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/31
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class SmsSendFactoryTest {
    @Test
    public void produce() throws Exception {
        Provider provider=new SmsSendFactory();
        Sender sender=provider.produce();
        sender.send();
    }

}