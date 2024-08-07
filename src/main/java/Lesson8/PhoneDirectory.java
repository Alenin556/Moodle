package Lesson8;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {

    // Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.

    // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

    //телефон уникальный ключ
    //фамилия может повторяться описываем как значение

    public  HashMap<String, String> peoplePhonesList = new HashMap<>();

    // В этот телефонный справочник с помощью метода add() можно добавлять записи
    public Map<String, String> add(String name, String phone) {

        peoplePhonesList.put(phone, name);
        return peoplePhonesList;
    }


    // а с помощью метода get() искать номер телефона по фамилии.
    public void get(String secondName) {

        Map<String,String> searchResult = new HashMap<>();

        for(Map.Entry<String, String> entry: peoplePhonesList.entrySet()) {
            //если совпадает имя тогда сохраняем ключ и значение в новую мапу
           if(entry.getValue().contains(secondName)){
               searchResult.put(entry.getKey(),entry.getValue());
           }

        }

        System.out.println(searchResult);
//
//        for(String name : peoplePhonesList.keySet()){
//            System.out.println(peoplePhonesList.get(name));
//            System.out.println(name);
//        }

    }


}
