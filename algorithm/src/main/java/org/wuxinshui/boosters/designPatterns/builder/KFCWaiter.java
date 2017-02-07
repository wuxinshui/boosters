package org.wuxinshui.boosters.designPatterns.builder;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class KFCWaiter {
    private MealBuilder builder;

    public void setBuilder(MealBuilder builder) {
        this.builder = builder;
    }


    public Meal construct(){
        //准备饮料
        builder.buildDrink();
        //准备食物
        builder.buildFood();
        //准备完毕，返回一个完整的套餐给客户
        return builder.getMeal();
    }
}
