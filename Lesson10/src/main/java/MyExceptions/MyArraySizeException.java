package MyExceptions;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(){
        super("This array is not 4x4");
    }
}
