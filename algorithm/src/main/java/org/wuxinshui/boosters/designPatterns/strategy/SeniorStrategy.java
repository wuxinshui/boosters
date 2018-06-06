package org.wuxinshui.boosters.designPatterns.strategy;

public class SeniorStrategy implements Strategy {
    @Override
    public double calPrice(double price) {
        System.out.println("高级会员八折优惠");
        return price*0.8;
    }
}
