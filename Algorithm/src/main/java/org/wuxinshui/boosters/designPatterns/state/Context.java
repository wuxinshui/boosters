package org.wuxinshui.boosters.designPatterns.state;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 *
 * 状态切换类
 */
public class Context {
    private State state;

    public Context(State state){
        this.state=state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method(){
        if ("m1".equals(state.getState())){
            state.method1();
        }else if ("m2".equals(state.getState())){
            state.method2();
        }
    }
}
