package Lesson7;

public class MyArraySizeException extends Throwable {

    public MyArraySizeException() {
        super("Двумерный массив должен быть размером 4x4");
    }
}