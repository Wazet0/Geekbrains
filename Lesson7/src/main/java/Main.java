import Animals.*;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 100),
                new Cat("Vasya", 50),
                new Cat("Murzik", 80),
                new Cat("Leva", 150)
        };
        Plate plate = new Plate(300);

        for(Cat cat : cats){
            cat.eat(plate);
            plate.addFood(1);

            cat.info();
            plate.info();
            System.out.println();
        }
    }
}
