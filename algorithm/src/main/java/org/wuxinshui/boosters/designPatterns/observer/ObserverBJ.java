package org.wuxinshui.boosters.designPatterns.observer;

public class ObserverBJ implements Observer {
    @Override
    public void update(String content) {
        System.out.println("北京观察站收到更新消息：" + content);
    }
}
