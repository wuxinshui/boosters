package org.wuxinshui.boosters.designPatterns.observer;

public class ObServerTest {
    public static void main(String[] args) {
        Subject weather = new WeatherSubject();
        System.out.println("上海站注册天气主题");
        Observer sh=new ObserverSH();
        weather.register(sh);

        System.out.println("北京站注册天气主题");
        Observer bj=new ObserverBJ();
        weather.register(bj);

        System.out.println("天气信息更新");
        ((WeatherSubject) weather).setState("温度29度，湿度30");
        weather.notice();
    }
}
