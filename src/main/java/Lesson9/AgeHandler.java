package Lesson9;

import java.util.List;

public class AgeHandler {

    public static void main(String[] args) {

        //4. Создай класс со следующим содержимым:
        //4.1. Необходимо узнать средний возраст студентов мужского пола;

        List<Integer> manAges = List.of(45,23,55,33,18,12,22,34,25,17,56,22,34,34,21,10);
        getMiddleAge(manAges);


    }

    public static void getMiddleAge(List<Integer> ages){
        //собрать сумму
        Integer sum = 0;
        for(Integer age : ages){
         sum += age;
        }
        //собрать количество
        long countAges = ages.stream().count();
        //среднее равно сумма деленная на количество
        long middleAge = sum /countAges;
        System.out.println(middleAge);
    }
}
