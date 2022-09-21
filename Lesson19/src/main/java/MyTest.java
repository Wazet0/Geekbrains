import tester.annotations.AfterSuite;
import tester.annotations.BeforeSuite;
import tester.annotations.Test;

public class MyTest {

    @BeforeSuite
    public void before(){
        System.out.println("BEFORE");
    }

    @AfterSuite
    public void after(){
        System.out.println("AFTER");
    }

    @Test
    public void test1(){
        System.out.println("This is method test1");
    }

    @Test(priority = 0)
    public void test2(){
        System.out.println("This is method test2");
    }

    @Test(priority = 7)
    public void test3(){
        System.out.println("This is method test3");
    }

    @Test(priority = 7)
    public void test4(){
        System.out.println("This is method test4");
    }
}
