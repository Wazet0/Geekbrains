import java.util.*;

import classes.TeleDictionary;

public class Main {
    public static void main(String[] args) {
        String arr[] = {
                "Серповидный",
                "Каравай",
                "Полгоря",
                "Предвзятый",
                "Серповидный",
                "Предвзятый",
                "Каравай",
                "Инки",
                "Американизировать",
                "Инки"
        };
        System.out.println("Массив: " + Arrays.toString(arr));
        System.out.println("Список уникальных слов: " + new HashSet<String>(Arrays.asList(arr)));

        HashMap<String, Integer> mapArr = new HashMap<>();
        for(String el : arr){
            if(mapArr.containsKey(el)){
                int val = mapArr.get(el);
                mapArr.remove(el);
                mapArr.put(el, val+1);
            }else{
                mapArr.put(el, 1);
            }
        }
        System.out.println("Сколько раз встречается каждый обьект: " + mapArr);

        System.out.println("--------");

        TeleDictionary dictionary = new TeleDictionary();
        dictionary.add("Timur", "123123");
        dictionary.add("Maxim", "321123");
        dictionary.add("Timur", "123456");
        dictionary.add("Artem", "854583");
        dictionary.add("Maxim", "654321");
        dictionary.add("Timur", "745215");

        System.out.println("Номера на имя Тимур: " + dictionary.get("Timur"));
        System.out.println("Номера на имя Максим: " + dictionary.get("Maxim"));
        System.out.println("Номера на имя Артем: " + dictionary.get("Artem"));
        System.out.println("Номера на имя Василий: " + dictionary.get("Vasiliy"));
    }
}
