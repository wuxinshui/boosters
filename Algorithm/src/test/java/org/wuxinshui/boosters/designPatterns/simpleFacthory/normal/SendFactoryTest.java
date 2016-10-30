package org.wuxinshui.boosters.designPatterns.simpleFacthory.normal;

import org.junit.Test;
import org.wuxinshui.boosters.designPatterns.simpleFacthory.normal.SendFactory;
import org.wuxinshui.boosters.designPatterns.simpleFacthory.normal.Sender;

/**
 * Created by FujiRen on 2016/10/28.
 */
public class SendFactoryTest {

    @Test
    public void producerTest(){
        String type="SMS";
        SendFactory factory=new SendFactory();
        Sender sender=factory.producer(type);
        sender.send();
    }

}