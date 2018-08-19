package org.wuxinshui.boosters.designPatterns.observer;

import java.util.HashSet;
import java.util.Set;

public class WeatherSubject implements Subject {
    private Set<Observer> observers;
    //天气状态
    private String state;

    public WeatherSubject() {
        this.observers = new HashSet<>();
    }

    public void notice() {
        System.out.println("获取到最新天气状态");
        System.out.println("状态更新了，开始通知观察者。。。");
        //    通知观察者
        for (Observer observer : observers) {
            observer.update("最新天气信息：" + state);
        }
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
