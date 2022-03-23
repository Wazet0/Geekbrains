public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(compare(10, 5));
        positiveOrNegative(-123);
        System.out.println(positiveOrNegative2(123));
        printLoop("Hello", 3);
        System.out.println(isVisocose(2022));
    }

    private static boolean compare(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void positiveOrNegative(int a){
        if(a >= 0){
            System.out.println("Число положительное");
        }else{
            System.out.println("Число отрицательное");
        }
    }

    private static boolean positiveOrNegative2(int a){
        return a < 0;
    }

    private static void printLoop(String str, int i){
        for(; i > 0; i--) System.out.println(str);
    }

    private static boolean isVisocose(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
