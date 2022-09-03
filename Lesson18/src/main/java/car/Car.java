package car;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{
    private static Car firstPass;
    private static int CARS_COUNT;
    static{
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    private static CyclicBarrier cyclicBarrier;
    private static CountDownLatch countDownLatch;

    private static Object pojo = new Object();

    public String getName(){
        return name;
    }

    public int getSpeed(){
        return speed;
    }

    public Car(Race race, int speed){
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + CARS_COUNT;
        CARS_COUNT++;
    }

    @Override
    public void run(){
        try{
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            cyclicBarrier.await();
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            countDownLatch.countDown();
        }catch(Exception e){
            e.printStackTrace();
        }
        for(int i = 0; i < race.getStages().size(); i++){
            race.getStages().get(i).go(this);
        }

        synchronized(pojo) {
            if (firstPass == null) {
                firstPass = this;
                System.out.println(name + " - WIN");
            }
        }
    }

    public static void setCyclicBarrier(CyclicBarrier cb){
        cyclicBarrier = cb;
    }
    public static void setCountDownLatch(CountDownLatch cdl){
        countDownLatch = cdl;
    }
    public static CyclicBarrier getCyclicBarrier(){ return cyclicBarrier; }
    public static CountDownLatch getCountDownLatch(){ return countDownLatch; }
}
