import car.Car;
import car.Race;
import car.obstacles.Road;
import car.obstacles.Tunnel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
    public static void main(String[] args) {
        Car.setCyclicBarrier(cyclicBarrier);
        Car.setCountDownLatch(countDownLatch);
        System.out.println("ВАЖНОЕ ОБЬЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel((int)(CARS_COUNT / 2)), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Thread[] threads = new Thread[CARS_COUNT];
        for(int i = 0; i < cars.length; i++){
            cars[i] = new Car(race, 20 + (int)(Math.random() * 10));
        }
        for(int i = 0; i < cars.length; i++){
            threads[i] = new Thread(cars[i]);
            threads[i].start();
        }
        try{
            countDownLatch.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЬЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЬЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
