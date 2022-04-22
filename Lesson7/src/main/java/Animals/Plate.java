package Animals;

public class Plate {
    private int food;

    public Plate(int food){
        this.food = food;
    }

    public void decreaseFood(int n){
        food = n > food ? 0 : food-n;
    }
    public void info(){
        System.out.println("Plate: " + food);
    }
    public void addFood(int n){
        food = n < 0 ? 0 : food + n;
    }

    public int getFood() {return this.food;}
}
