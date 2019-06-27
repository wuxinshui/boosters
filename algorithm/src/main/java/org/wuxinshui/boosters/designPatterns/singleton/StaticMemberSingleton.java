package org.wuxinshui.boosters.designPatterns.singleton;

/**
 * 任何对StaticMemberSingleton 方法或者字段的引用，都会导致类初始化
 * 并创建instance实例
 * 但是类初始化只有一次
 * 因此instance实例永远只会被创建一次
 */
public class StaticMemberSingleton {
    private final static int STATUS = 1;

    private StaticMemberSingleton() {
        System.out.println("singleton init...");
    }

    private final static StaticMemberSingleton instance = new StaticMemberSingleton();

    public StaticMemberSingleton getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(StaticMemberSingleton.STATUS);
    }

}
