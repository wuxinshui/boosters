package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 7:31
 * To change this template use File | Settings | File Templates.
 */
//饿汉模式
public class HungrySingleton {
    //利用静态变量来记录singleton的唯一实例
    private final static HungrySingleton uniqueInstance=new HungrySingleton();

    /**
     * 构造器私有化，只有singleton内部才可以调用
     * 确保不会被其他代码实例化
     */
    private HungrySingleton(){
        System.out.println("HungrySingleton is create");
    }

    public static HungrySingleton getInstance(){
        return uniqueInstance;
    }
    //其他角色
    public static void createString(){
        System.out.println("createString in HungrySingleton");
    }

    public static void main(String[] args) {
        HungrySingleton.createString();
    }
}
