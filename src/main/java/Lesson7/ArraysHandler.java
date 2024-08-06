package Lesson7;

import java.util.Arrays;

public class ArraysHandler {

    int[][] twoDimArray = new int[3][4];


    public static Integer getSumFromCells(String[][] twoArray) throws MyArraySizeException {

        // Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
        // При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        //Метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        Integer[][] newTwoArray = new Integer[4][4];
        Integer sum = 0;

        if (twoArray.length < 4 || twoArray.length > 4) {
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < 4; i++) { // идем по строкам
                for (int j = 0; j < 4; j++) {//идём по столбцам
                    newTwoArray[i][j] = Integer.valueOf(twoArray[i][j]);
                    sum += newTwoArray[i][j];
                }
            }
            System.out.println("На вход дан двумерный массив для расчета суммы : \n");
            System.out.println(Arrays.deepToString(newTwoArray).replace("], ", "]\n"));
        }

        //Метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.


        System.out.println("Cумма чисел в двумерном массиве = " + sum);
        return sum;

            // Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
            // должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
            //
            //В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.

//        Integer[][] newTwoArray;
//
//        for (int i = 0; i < 4; i++){ // идем по строкам
//            for (int j = 0; j < 4; j++) {//идём по столбцам
//                try {
//                    newTwoArray[i][j] = Integer.valueOf(twoArray[i][j]);
//                } catch (Error error){
//                    System.out.println("Error");
//                }
//
//            }
//        }


//            if (twoArray.length < 4 || twoArray.length > 4) {
//                throw new MyArraySizeException();
//            } else {
//                System.out.println("На вход дан двумерный массив для расчета суммы : \n");
//                System.out.println(Arrays.deepToString(twoArray).replace("], ", "]\n"));
//            }
//



        }
    }
