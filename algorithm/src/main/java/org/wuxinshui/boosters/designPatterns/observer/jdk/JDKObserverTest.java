package org.wuxinshui.boosters.designPatterns.observer.jdk;

import java.util.Observable;

public class JDKObserverTest {
    public static void main(String[] args) {
        Observable weatherData=new WeatherData();

        ObserverHZ hz=new ObserverHZ();
        ObserverNJ nj=new ObserverNJ();
        weatherData.addObserver(hz);
        weatherData.addObserver(nj);

        ((WeatherData) weatherData).setState("温度29度，湿度30\"");
        //((WeatherData) weatherData).setChanged();
        //weatherData.notifyObservers("温度29度，湿度30");
    }
}
