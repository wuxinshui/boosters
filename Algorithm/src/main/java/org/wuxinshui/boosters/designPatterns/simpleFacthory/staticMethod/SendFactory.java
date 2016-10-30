package org.wuxinshui.boosters.designPatterns.simpleFacthory.staticMethod;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/10/30
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 * 简单工厂模式不属于23中涉及模式，简单工厂一般分为：普通简单工厂、多方法简单工厂、静态方法简单工厂。
 */
public class SendFactory {
    public static Sender produceEmail() {
        return new Email();
    }

    public static Sender produceSms() {
        return new Sms();
    }
}
