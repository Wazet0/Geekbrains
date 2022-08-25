package fruits;

import fruits.Fruit.Fruit;

public class Orange implements Fruit {
    public static float WEIGHT = 1.5F;
    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString(){
        return "Orange";
    }
}
