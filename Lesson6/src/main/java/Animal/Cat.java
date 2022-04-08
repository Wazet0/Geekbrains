package Animal;

public class Cat extends Animal{
    public static int count = 0;

    public Cat(String name){
        this.name = name;
        count++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот не может столько пробежать.");
        }else{
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }
}
