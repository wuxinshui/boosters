package org.wuxinshui.boosters.designPatterns.simpleFacthory.normal;

/**
 * Created by FujiRen on 2016/10/28.
 * 简单工厂模式不属于23中涉及模式，简单工厂一般分为：普通简单工厂、多方法简单工厂、静态方法简单工厂。
 */
public class SendFactory {
    public Sender producer(String type) {
        if ("EMAIL".equals(type)) {
            return new Email();
        } else if ("SMS".equals(type)) {
            return new Sms();
        } else {
            return null;
        }
    }
}
