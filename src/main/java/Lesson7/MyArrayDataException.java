package Lesson7;

public class MyArrayDataException extends Throwable {

    public MyArrayDataException() {
        super("Двумерный массив содержит не верный тип данных");
    }

}
