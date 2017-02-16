package org.wuxinshui.boosters.designPatterns.decorator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/15
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
public class DecoratorTest {
    @Test
    public void print() throws Exception {
        Sourceable sourceable=new Source();
        Sourceable decorator=new Decorator(sourceable);
        decorator.print();

    }

}