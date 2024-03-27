package MoodleAQAJavaCourse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson4 {

    public static void main(String[] args) {

        Person[] person = new Person[5];
        person[0] = new Person("Alenin Andrew","AQA","","+79315762030","10000000",35);
        person[1] = new Person("Karoeva Katerina","AQA","","+79219304558","10000000",40);
        person[2] = new Person("Alexeev Alexey","DEV","","+79814562978","10000000",45);
        person[3] = new Person("Alexandrov Alex","AQA","","+78922564815","10000000",56);
        person[4] = new Person("Stepanov Stepan","DEV","","+78114562301","10000000",78);

        if(person[0].age >40){
            System.out.println(person[0].FIO);
        }

//        getNamePersonAgeAbove40(person);
    }

    static class Person{
        String FIO;
        String position;
        String email;
        String phone;
        String salary;
        Integer age;

        public Person(String FIO, String position, String email, String phone, String salary, Integer age) {
            this.FIO = FIO;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }

        public String getFIO() {
            return FIO;
        }

    }

    private static void getNamePersonAgeAbove40(Person[] person) {
        String name = null;

//        for (Person pers : person){
//            if(pers.age > 40){
//                name = pers.getFIO();
//            }
//        }
//
//        for (Person pers : person) {
//            if (Arrays.stream(person).anyMatch(n -> n.age > 40)) {
//                name = pers.getFIO();
//                System.out.println(name);
//            }
//        }
    }
}
