package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] nums = new Integer[]{1,2,3,4,5,6,7,8,9,10};

        getFactorial(nums);
    }

    public static String successNotification = "Array isEmpty !";
    public static String resultNotification = "Result : ";


    // TODO получить на вход список массив чисел
    //  факториал это произведение всех чисел до этого числа
    //  отдать результат
    public static Integer getFactorial(Integer[] numbers){
        Integer result = 1;

        if (numbers.length == 0){
            System.out.println(successNotification);
            return null;
        } else {
            for(Integer x : numbers){
                result*=x;
            }
            System.out.println(resultNotification + result);
            return result;
        }
    }
}