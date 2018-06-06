package org.wuxinshui.boosters.designPatterns.strategy;

public class MiddleStrategy implements Strategy {
    @Override
    public double calPrice(double price) {
        System.out.println("中级会员九折优惠");
        return price*0.9;
    }
}
