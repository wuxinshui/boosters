package org.wuxinshui.boosters.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public class VeggiePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing"+name);
        veggies=ingredientFactory.createVeggies();
        clams=ingredientFactory.createClams();

    }
}
