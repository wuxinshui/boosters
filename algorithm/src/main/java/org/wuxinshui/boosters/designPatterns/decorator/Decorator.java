package org.wuxinshui.boosters.designPatterns.decorator;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/15
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 *
 * 装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */
public class Decorator implements Sourceable {

    private Sourceable sourceable;

    public Decorator(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    @Override
    public void print() {
        System.out.println("before print");
        sourceable.print();
        System.out.println("after print");
    }
}
