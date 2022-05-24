public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        method1();
        method2();
    }

    private static void method1(){
        float[] arr = new float[size];

        for(int i = 0; i < size; i++){
            arr[i] = 1;
        }

        long start_time = System.currentTimeMillis();
        for(int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end_time = System.currentTimeMillis();

        System.out.println("Метод без потоков:" + (end_time - start_time) + " ms");
    }

    private static void method2(){
        float[] arr = new float[size];

        for(int i = 0; i < size; i++){
            arr[i] = 1;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long start_time = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, 0, a2, 0, h);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < h; i++){
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < h; i++){
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start();
        thread2.start();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long end_time = System.currentTimeMillis();
        System.out.println("Метод с потоками: " + (end_time - start_time) + " ms");
    }
}
