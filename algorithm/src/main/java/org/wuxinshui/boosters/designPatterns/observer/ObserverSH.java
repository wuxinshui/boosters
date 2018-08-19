package org.wuxinshui.boosters.designPatterns.observer;

public class ObserverSH implements Observer {
    @Override
    public void update(String content) {
        System.out.println("上海观察站收到更新消息："+content);
    }
}
