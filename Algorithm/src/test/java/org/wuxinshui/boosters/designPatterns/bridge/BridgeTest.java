package org.wuxinshui.boosters.designPatterns.bridge;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class BridgeTest {

    @Test
    public void method() throws Exception {
        Bridge bridge = new MyBridge();
        Sourceable sourceable1 = new SourceSub1();
        bridge.setSourceable(sourceable1);
        bridge.method();

        Sourceable sourceable2 = new SourceSub2();
        bridge.setSourceable(sourceable2);
        bridge.method();
    }


}