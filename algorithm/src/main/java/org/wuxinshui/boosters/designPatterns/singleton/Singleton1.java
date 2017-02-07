package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 7:31
 * To change this template use File | Settings | File Templates.
 */
public class Singleton1 {
    //利用静态变量来记录singleton的唯一实例
    private static Singleton1 uniqueInstance=new Singleton1();

    /**
     * 构造器私有化，只有singleton内部才可以调用
     * 确保不会被其他代码实例化
     */
    private Singleton1(){
        System.out.println("Singleton is create");
    }

    public static Singleton1 getInstance(){
        return uniqueInstance;
    }

    public static void createString(){
        System.out.println("createString in Singleton");
    }
}
