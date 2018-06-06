package org.wuxinshui.boosters.designPatterns.strategy;

public class PrimaryStrategy implements Strategy {
    @Override
    public double calPrice(double price) {
        System.out.println("初级会员没优惠。。。");
        return price;
    }
}
