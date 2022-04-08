package Animal;

public class Dog extends Animal{
    public static int count = 0;

    public Dog(String name){
        this.name = name;
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака не может столько пробежать.");
        }else{
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака не может столько проплыть.");
        }else{
            super.swim(distance);
        }
    }
}
