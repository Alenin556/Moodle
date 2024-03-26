package MoodleAQAJavaCourse;

public class Lesson2 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(10, 5);
        checkSumSign(-10, -10);
        printColor(0);
        printColor(1);
        printColor(100);
        printColor(101);
        compareNumbers(10,10);
        compareNumbers(0,10);
    }

    private static void  printThreeWords(){
        System.out.println("Orange, Banana, Apple");
    }

    private static void checkSumSign(int a, int b) {
       int result = a + b;
       if (result >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor(int value){
        if (value <= 0){
            System.out.println("Красный");
        } else if (value>=0 && value <= 100 ) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void  compareNumbers(int a, int b){
        if (a>=b){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
