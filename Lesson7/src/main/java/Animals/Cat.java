package Animals;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate p){
        if(!isFull) {
            if (p.getFood() - this.appetite >= 0) {
                this.isFull = true;
                p.decreaseFood(appetite);
            }
        }
    }
    public void info(){
        System.out.println(this.name + " сытый: " + this.isFull);
    }
}
