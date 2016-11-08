package org.wuxinshui.boosters.designPatterns.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class SourceSub2 implements Sourceable {
    @Override
    public void method() {
        System.out.println("This is second sub2");
    }
}
