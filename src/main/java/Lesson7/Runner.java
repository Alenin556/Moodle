package Lesson7;

import java.util.Arrays;
import java.util.Objects;

import static Lesson7.ArraysHandler.getSumFromCells;

public class Runner {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {


        //В методе main() вызвать полученный метод, обработать возможные исключения MyArrayDataException и MyArrayDataException и вывести результат расчета.


        String[][] twoDimArray = new String[][]{{"1", "1", "0", "3"}, {"2", "1", "1", "1"}, {"1", "2", "1", "1"}, {"0", "3", "1", "1"}};
        String[][] twoDimArrayLengthException = new String[][]{{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] twoDimArrayTypeException = new String[][]{{"1", "1", "a", "1"}, {"1", "м", "1", "о"}, {"1", "п", "1", "1"},{"a", "f", "1", "1"}};




        getSumFromCells(twoDimArrayTypeException);

    }
}
