import MyExceptions.MyArrayDataException;
import MyExceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args){
        try {
            int result = checkArray(new String[][]{
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"1", "2", "3", "4"},
                    {"a", "2", "3", "4"}
            });
            System.out.println(result);
        }catch(MyArrayDataException e){
            System.out.println(e.getMessage());
        }catch(MyArraySizeException e){
            System.out.println(e.getMessage());
        }
    }

    private static int checkArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) throw new MyArraySizeException();
        for (String[] subArr : arr) {
            if (subArr.length != 4) throw new MyArraySizeException();
        }

        int sum = 0;

        for(String[] subArr : arr){
            for(String el : subArr){
                try{
                    sum += Integer.parseInt(el);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException();
                }
            }
        }
        return sum;
    }
}


