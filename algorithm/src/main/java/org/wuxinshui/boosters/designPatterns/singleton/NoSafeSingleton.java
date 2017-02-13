package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 7:31
 * To change this template use File | Settings | File Templates.
 */
//线程不安全的懒汉模式
public class NoSafeSingleton {
    //利用静态变量来记录singleton的唯一实例
    private static NoSafeSingleton uniqueInstance;

    /**
     * 构造器私有化，只有singleton内部才可以调用
     * 确保不会被其他代码实例化
     */
    private NoSafeSingleton(){
    }

    //线程不安全
    //第一个线程进来判断 uniqueInstance == null，还没有new 出实例的时候 。
    // 这个时候第二个线程也进来了，判断的uniqueInstance 也是 null，然后也会 new 出实例的
    public static NoSafeSingleton getInstance(){
        if (null==uniqueInstance){
            uniqueInstance=new NoSafeSingleton();
        }
        return uniqueInstance;
    }
}
