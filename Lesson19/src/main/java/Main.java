import tester.Tester;

public class Main {
    public static void main(String[] args) {
        try {
            Tester.test(MyTest.class);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }
}
