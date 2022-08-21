import fruits.Fruit.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit>{
    private ArrayList<T> box;

    public Box(){
        box = new ArrayList<>();
    }

    public void putFruit(T fruit){
        box.add(fruit);
    }

    public float getWeight(){
        float weight = 0.0F;
        for(T fruit : box){
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> someBox){
        if(this.getWeight() == someBox.getWeight()){
            return true;
        }
        return false;
    }

    public void throwIntoAnother(Box<T> someBox){
        for(int i = 0; i < this.box.size(); i++){
            T fruit = this.box.get(i);
            this.box.remove(fruit);
            someBox.putFruit(fruit);
        }
    }

    @Override
    public String toString(){
        return this.getWeight() + this.box.toString();
    }
}
