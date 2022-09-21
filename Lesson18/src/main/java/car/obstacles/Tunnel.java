package car.obstacles;

import car.Car;
import car.obstacles.Stage.Stage;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public Semaphore semaphore;
    public Tunnel(int carsInMoment){
        semaphore = new Semaphore(carsInMoment);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c){
        try{
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            semaphore.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            semaphore.release();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println(c.getName() + " закончил этап: " + description);
        }
    }
}
