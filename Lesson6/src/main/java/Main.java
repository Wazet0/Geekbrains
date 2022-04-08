import Animal.Dog;
import Animal.Cat;

public class Main {
    public static void main(String[] args) {
        Cat[] arrCats = {
                new Cat("Мурзик"),
                new Cat("Дуся"),
                new Cat("Вася")
        };

        Dog[] arrDogs = {
                new Dog("Бобик"),
                new Dog("Шарик"),
                new Dog("Палван")
        };

        for(int i = 0, j = 100; i < 3; i++, j+=100){
            arrDogs[i].run(j);
            arrCats[i].run(j);
        }
        System.out.println();
        for(int i = 0, j = 9; i < 3; i++, j+=1){
            arrDogs[i].swim(j);
            arrCats[i].swim(j);
        }

        System.out.printf("\nЧисло котов %d\nЧисло собак: %d", Cat.count, Dog.count);
    }
}
