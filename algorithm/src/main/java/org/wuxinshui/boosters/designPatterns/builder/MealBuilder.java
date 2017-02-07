package org.wuxinshui.boosters.designPatterns.builder;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 11:12
 * To change this template use File | Settings | File Templates.
 */
public abstract class MealBuilder {
    Meal meal=new Meal();

    public abstract void buildFood();
    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
