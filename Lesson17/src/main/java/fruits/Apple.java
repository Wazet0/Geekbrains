package fruits;

import fruits.Fruit.Fruit;

public class Apple implements Fruit {
    public static float WEIGHT = 1.0F;
    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString(){
        return "Apple";
    }
}
