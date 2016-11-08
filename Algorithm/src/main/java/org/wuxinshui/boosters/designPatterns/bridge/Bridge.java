package org.wuxinshui.boosters.designPatterns.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/8
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，
 */
public abstract class Bridge {
    private Sourceable sourceable;

    public void method(){
        sourceable.method();
    }

    public Sourceable getSourceable() {
        return sourceable;
    }

    public void setSourceable(Sourceable sourceable) {
        this.sourceable = sourceable;
    }
}
