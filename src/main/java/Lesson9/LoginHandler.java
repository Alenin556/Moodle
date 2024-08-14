package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoginHandler {
    //5. Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
    // Как только пользователь введет пустую строку - программа должна прекратить приём данных от пользователя
    // и вывести в консоль логины, начинающиеся на букву f (строчную).
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> loginList = new ArrayList<>();

        System.out.println("Введите login =)");
        String login;

//        do {
//            login = sc.nextLine();
//            loginList.add(login);
//            System.out.println("Login : " + login);
//            System.out.println("Введите login =)");
//            if (login.equals("")) {
//                List<String> fLoginsStartWith = loginList.stream().filter(n -> n.startsWith("f")).collect(Collectors.toList());
//                System.out.println(fLoginsStartWith);
//            }
//        }
//        while (!login.equals(""));


        List<String> fLoginsStartWith = new ArrayList<>();
        do {
            login = sc.nextLine();
            if(login.startsWith(" ")){
                break;
            } else {
                loginList.add(login);
                System.out.println("Login : " + login);
                System.out.println("Введите login =)");
                fLoginsStartWith = loginList.stream().filter(n -> n.startsWith("f")).collect(Collectors.toList());
                //если значение последнего логина null тогда конец
            }
        }
        while (!(login.length() == 0));
        System.out.println(fLoginsStartWith);
        System.out.println(loginList);
    }


}
