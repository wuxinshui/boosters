package org.wuxinshui.boosters.designPatterns.abstractFactory;

import org.wuxinshui.boosters.designPatterns.abstractFactory.source.*;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 *
 * 在接口中，每个原料都有一个对应的方法创建该原料
 */
public interface PizzaIngredientFactory {
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClams();
}
