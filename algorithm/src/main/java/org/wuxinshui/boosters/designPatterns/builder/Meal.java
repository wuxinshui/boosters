package org.wuxinshui.boosters.designPatterns.builder;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
public class Meal {
   private String drink;
   private String food;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {

        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
