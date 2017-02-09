package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * Created by Administrator on 2017/2/8.
 */
//最简洁的单例模式
//无偿地提供了序列化机制，绝对防止多次实例化
public enum SingletonEnum {
    INSTANCE;

    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum == singletonEnum1);
        System.out.println(singletonEnum.getClass());
    }
}
