package org.wuxinshui.boosters.designPatterns.state;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class ContextTest {

    @Test
    public void test(){
        State state=new State();

        //状态1
        state.setState("m1");
        Context context=new Context(state);
        context.method();

        //状态2
        state.setState("m2");
        context.method();
    }

}