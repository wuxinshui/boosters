package org.wuxinshui.boosters.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 */
public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory=ingredientFactory;
        prepare();
    }


    @Override
    void prepare() {
        System.out.println("Preparing"+name);
        dough=ingredientFactory.createDough();
        sauce=ingredientFactory.createSauce();
        cheese=ingredientFactory.createCheese();
    }
}
