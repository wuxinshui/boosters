package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 7:31
 * To change this template use File | Settings | File Templates.
 */
public class Singleton {
    //利用静态变量来记录singleton的唯一实例
    private static Singleton uniqueInstance;

    /**
     * 构造器私有化，只有singleton内部才可以调用
     */
    private Singleton(){

    }

    public static Singleton getInstance(){
        if (null==uniqueInstance){
            uniqueInstance=new Singleton();
        }
        return uniqueInstance;
    }
}
