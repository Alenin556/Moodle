package MoodleAQAJavaCourse;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson3 {

    public static void main(String[] args) {

        System.out.println(Bool(1, 1));
        System.out.println(checkNumber(0));
        printXText("Привет я изучаю Java", 4);

        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        switch01(array);

        int[] arr = new int[100];
        pullNumbersInMas(arr);
    }

    private static boolean Bool(int a, int b) {
        boolean result;
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private static boolean checkNumber(int number) {
        boolean result;

        if (number >= 0) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    private static void printXText(String string, int x) {
        System.out.println(string.repeat(x));
    }

    private static void switch01(int[] mas) {

        for (int array : mas) {
            if (array == 0) {
                array = 1;
            } else {
                array = 0;
            }
            System.out.println(array);
        }

        //        int[] newMas = new int[10];
//            for(int i = 0; i <=newMas.length; i++){
//                for (int array : mas){
//                    if(array == 0){
//                        array = 1;
//                    } else {
//                        array = 0;
//                    }
//                newMas[i] = array;
//            }
//        }
//        return newMas;
    }

    private static void pullNumbersInMas(int[] array) {
        try {
            for (int i = 0; i <= array.length; i++) {
                array[i] = i;
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Ошибка индекса");
        }
        System.out.println(Arrays.toString(array));
    }

//    private static int[] x2(int[] array) {
////        for(int x : array){
////            if (x<6){
////                x*2
////            }
////        }
//    }
}






