package Chernovik;

import java.util.Arrays;

public class Arraysss {

    public static void main(String[] args) {

        int[] array = new int[100];
//        array[0] = 10;

        try {
            for (int i = 1; i <= array.length; i++) {
                array[i] = i;
            }
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Ошибка индекса");
        }
        System.out.println(Arrays.toString(array));


        System.out.println("___________________________________");


        int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] newArray2 = new int[9];
        for (int i = 0; i <= newArray2.length; i++){
            for (int x : array2) {
                if (x < 6) {
                    int newNumber = x*2;
                    newArray2[i] = newNumber;
                    i++; // почему не видно дейстиве в скобках условия??
                }
            }
        }
        System.out.println(Arrays.toString(newArray2));
    }
}
