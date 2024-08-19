package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        getFactorial(nums);
    }

    public static String successNotification = "Array isEmpty !";
    public static String resultNotification = "Result : ";
    public static Integer intLength = 2147483647;


    // TODO получить на вход список массив чисел
    //  факториал это произведение всех чисел до этого числа
    //  отдать результат
    public static Integer getFactorial(Integer[] numbers) {
        Integer result = 1;

        if (numbers.length == 0) {
            System.out.println(successNotification);
            return null;
        } else {
            for (Integer x : numbers) {
                //TODO Нет обработки отрицательных значений в методе , и  тестирование этой обработки
                if (x < 0) {
                    System.out.println("To calculate the factorial, the number cannot be less than zero");
                    return null;
                } else {
                    result *= x;
                }
            }
            if(result.toString().startsWith("-")){
                System.out.println("The result is more Integer type value");
                return null;
            } else {
                System.out.println(resultNotification + result);
                return result;
            }
        }
    }
}