package org.wuxinshui.boosters.designPatterns.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * User: FujiRen
 * Date: 2016/11/11
 * Time: 10:49
 * To change this template use File | Settings | File Templates.
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
         //使用纽约的原料工厂
         PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
         if("cheese".equals(type)){
                 pizza = new CheesePizza(ingredientFactory);
                  pizza.setName("New York Style Cheese Pizza");
              }
          else if("veggie".equals(type)){
                  pizza = new VeggiePizza(ingredientFactory);
                  pizza.setName("New York Style Veggie Pizza");
              }
          else if("clam".equals(type)){
                  pizza = new ClamPizza(ingredientFactory);
                  pizza.setName("New York Style Clam Pizza");
              }
          else if("pepperoni".equals(type)){
                  pizza = new PepperoniPizza(ingredientFactory);
                  pizza.setName("New York Style Pepperoni Pizza");
              }
          return pizza;
    }
}
