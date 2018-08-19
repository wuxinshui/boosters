package org.wuxinshui.boosters.designPatterns.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class ObserverNJ implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("南京站 最新天气信息: " + arg);
    }
}
