package org.wuxinshui.boosters.designPatterns.builder;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args) {
        KFCWaiter waiter=new KFCWaiter();

        MealA a=new MealA();
        waiter.setBuilder(a);

        Meal mealA=waiter.construct();

        MealB b=new MealB();
        waiter.setBuilder(b);

        Meal mealB=waiter.construct();

        System.out.println("套餐B："+mealB.getDrink());
    }
}
