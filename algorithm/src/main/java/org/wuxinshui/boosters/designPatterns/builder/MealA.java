package org.wuxinshui.boosters.designPatterns.builder;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class MealA extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("jitui");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("kele");
    }
}
