package org.wuxinshui.boosters.designPatterns.simpleFacthory.moreMethods;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by FujiRen on 2016/10/30.
 */
public class SendFactoryTest {
    @Test
    public void produceEmail() throws Exception {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceEmail();
        sender.send();
    }

    @Test
    public void produceSms() throws Exception {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceSms();
        sender.send();
    }

}