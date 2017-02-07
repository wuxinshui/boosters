package org.wuxinshui.boosters.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza=createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();;
        pizza.box();
        return pizza;
    }


    abstract Pizza createPizza(String type);
}
