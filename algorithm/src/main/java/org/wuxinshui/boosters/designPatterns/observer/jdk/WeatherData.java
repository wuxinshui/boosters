package org.wuxinshui.boosters.designPatterns.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {
    //天气状态
    private String state;

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("接受到天气信息更新。。。："+state);
        super.setChanged();
        System.out.println("天气信息更新了，通知观察者。。。");
        super.notifyObservers(state);
    }
}
