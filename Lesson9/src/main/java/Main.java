import classes.*;

public class Main {
    public static void main(String[] args) {
        Barrier[] barriers = {
                new RunWay(10),
                new Wall(20),
                new Wall(30),
                new RunWay(15)
        };
        Entity[] entities = {
                new Cat("Murzik", 20),
                new Human("Vasiliy", 29),
                new Robot("Alisa", 100)
        };

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(entities[j].getIsPassed()){
                    barriers[i].tryAction(entities[j]);
                }
            }
        }
    }
}
