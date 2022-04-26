package MyExceptions;

public class MyArrayDataException extends ArrayIndexOutOfBoundsException{
    public MyArrayDataException(){
        super("This array contains a string that doesn\'t look like a number");
    }
}
