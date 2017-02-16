package org.wuxinshui.boosters.designPatterns.simpleFacthory.staticMethod;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/30
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public class sendFactoryTest {
    @Test
    public void produceEmail() throws Exception {
    SendFactory.produceEmail().send();
    }

    @Test
    public void produceSms() throws Exception {
    SendFactory.produceSms().send();
    }

}