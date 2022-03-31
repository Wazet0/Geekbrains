import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        //1
        System.out.println(Arrays.toString(changeOneToZero(new int[]{1, 0, 0, 1})));
        //2
        System.out.println(Arrays.toString(createArr100()));
        //3
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(magic(array)));
        //4
        int[][] array2d = {
                {2, 4, 6},
                {8, 10, 12},
                {14, 16, 18}
        };
        System.out.println(Arrays.deepToString(diagsToOne(array2d)));
        //5
        System.out.println(Arrays.toString(createArray(5, 3)));
        //6
        printMinAndMaxOfArray(new int[]{1, 9, 7, 4, 5, 5, 8});
        //7
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        //8, не смог. Сложновато
    }

    private static int[] changeOneToZero(int[] arr){
        for(int i = 0; i < arr.length; i++) arr[i] = (arr[i] == 1) ? 0 : 1;
        return arr;
    }

    private static int[] createArr100(){
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++) arr[i] = i + 1;
        return arr;
    }

    private static int[] magic(int[] arr){
        for(int i = 0; i < arr.length; i++) arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
        return arr;
    }

    private static int[][] diagsToOne(int[][] array2d){ //две диагонали!
        for(int i = 0; i < array2d.length; i++) array2d[i][i] = 1;
        for(int i = 0, j = array2d.length-1; i < array2d.length; i++, j--) array2d[i][j] = 1;
        return array2d;
    }

    private static int[] createArray(int initialValue, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) arr[i] = initialValue;
        return arr;
    }

    private static void printMinAndMaxOfArray(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            min = min > arr[i] ? arr[i] : min;
            max = max < arr[i] ? arr[i] : max;
        }
        System.out.println("Min -> " + min);
        System.out.println("Max -> " + max);
    }

    private static boolean checkBalance(int[] arr){
        int leftSum = 0, rightSum = 0;
        for(int balance = 1; balance < arr.length; balance++){
            for(int iLeft = 0; iLeft < balance; iLeft++) leftSum += arr[iLeft];
            for(int iRight = arr.length - 1; iRight >= balance; iRight--) rightSum += arr[iRight];
            if(leftSum == rightSum) return true;
            leftSum = rightSum = 0;
        }
        return false;
    }
}
