package Lesson7;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


public class ArraysHandler {

    static Logger logger = LoggerFactory.getLogger("SampleLogger");


    // Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    public static Integer getSumFromCells(String[][] twoArray) throws MyArraySizeException, MyArrayDataException {

        Integer[][] newTwoArray = new Integer[4][4];
        Integer sum = 0;
        String exceptionValue = null;

        if (twoArray.length < 4 || twoArray.length > 4) {
            // При подаче массива другого размера необходимо бросить исключение MyArrayDataException.
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < 4; i++) { // идем по строкам
                for (int j = 0; j < 4; j++) {//идём по столбцам
                    try {
                        //Метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
                        newTwoArray[i][j] = Integer.valueOf(twoArray[i][j]);
                        sum += newTwoArray[i][j];

                    } catch (NumberFormatException exception) {
                        // Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
                        // должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

                        exceptionValue = String.valueOf(twoArray[i][j]);
                        System.out.println((Arrays.toString(newTwoArray[i])));
                        logger.error("Exception in value : " + exceptionValue);
                        throw new MyArrayDataException();
                    }
                }
            }
            System.out.println("На вход дан двумерный массив для расчета суммы : \n"
                    + (Arrays.deepToString(newTwoArray).replace("], ", "]\n")));
        }


        System.out.println("Обработка выполнена успешно :");
        System.out.println("Cумма чисел в двумерном массиве = " + sum);
        return sum;

    }
}
