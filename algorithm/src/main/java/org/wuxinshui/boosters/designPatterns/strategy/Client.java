package org.wuxinshui.boosters.designPatterns.strategy;

public class Client {

    public static void main(String[] args) {
        Strategy strategy=new MiddleStrategy();
        Price price=new Price(strategy);
        price.quote(100);
    }
}
