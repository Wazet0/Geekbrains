import fruits.Apple;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"1", "2", "3"};
        try {
            System.out.println(Arrays.toString(reverse(array, 0, 2)));
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println(toArrayList(array).getClass());



        Box<Apple> appleBox = new Box<>();
        appleBox.putFruit(new Apple());
        appleBox.putFruit(new Apple());
        appleBox.putFruit(new Apple());
        appleBox.putFruit(new Apple());
        appleBox.putFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.putFruit(new Apple());
        appleBox2.putFruit(new Apple());
        appleBox2.putFruit(new Apple());
        appleBox2.putFruit(new Apple());
        appleBox2.putFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.putFruit(new Orange());
        orangeBox.putFruit(new Orange());
        orangeBox.putFruit(new Orange());

        System.out.println(orangeBox);
        System.out.println(appleBox);
        System.out.println(appleBox2);
        System.out.println(appleBox.compare(appleBox2));
    }

    private static <T> T[] reverse(T[] arr, int i1, int i2) throws ArrayIndexOutOfBoundsException{
        T temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
        return arr;
    }

    private static <T> ArrayList<T> toArrayList(T[] array){
        return new ArrayList<>(List.of(array));
    }
}
