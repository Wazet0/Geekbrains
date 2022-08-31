import car.Car;
import car.Race;
import car.obstacles.Road;
import car.obstacles.Tunnel;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЬЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for(int i = 0; i < cars.length; i++){
            cars[i] = new Car(race, 20 + (int)(Math.random() * 10));
        }
        for(int i = 0; i < cars.length; i++){
            new Thread(cars[i]).start();
        }
        System.out.println("ВАЖНОЕ ОБЬЯВЛЕНИЕ >>> Гонка началась!!!");
        System.out.println("ВАЖНОЕ ОБЬЯВЛЕНИЕ >>> Гона закончилась!!!");
    }
}
