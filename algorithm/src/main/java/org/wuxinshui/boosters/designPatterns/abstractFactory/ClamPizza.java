package org.wuxinshui.boosters.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 10:35
 * To change this template use File | Settings | File Templates.
 */
public class ClamPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        prepare();
    }

    @Override
    void prepare() {
        System.out.println("Preparing"+name);
        dough=ingredientFactory.createDough();
        sauce=ingredientFactory.createSauce();
        cheese=ingredientFactory.createCheese();
        clams= ingredientFactory.createClams();
    }
}
