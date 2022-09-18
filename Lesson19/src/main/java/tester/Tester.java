package tester;

import tester.annotations.AfterSuite;
import tester.annotations.BeforeSuite;
import tester.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Tester {
    public static void test(Class cls) throws RuntimeException{
        Method[] methods = cls.getDeclaredMethods();
        Object obj;
        try {
            obj = cls.getConstructors()[0].newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        Method beforeMethod = null;
        ArrayList<Method> testMethods[] = new ArrayList[]{
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        };
        Method afterMethod = null;

        for(Method method: methods){
            if(method.getAnnotation(Test.class) != null){
                int priority = method.getAnnotation(Test.class).priority();
                testMethods[priority].add(method);
            }else if(method.getAnnotation(BeforeSuite.class) != null){
                if(beforeMethod != null){
                    throw new RuntimeException("Test class don`t has over 1 method with annotation 'BeforeSuite'");
                }else{
                    beforeMethod = method;
                }
            }else if(method.getAnnotation(AfterSuite.class) != null){
                if(afterMethod != null){
                    throw new RuntimeException("Test class don`t has over 1 method with annotation 'AfterSuite'");
                }else{
                    afterMethod = method;
                }
            }
        }

        //Run
        try {
            if(beforeMethod != null) {
                beforeMethod.invoke(obj);
            }
            for (ArrayList<Method> arrMethod : testMethods) {
                for (Method method : arrMethod) {
                    method.invoke(obj);
                }
            }
            if(afterMethod != null) {
                afterMethod.invoke(obj);
            }
        }catch(InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
        //Run
    }
}
