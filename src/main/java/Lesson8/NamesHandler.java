package Lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NamesHandler {


    // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    // Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)
    public static void main(String[] args) {

        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        List <String> names = new ArrayList<>();
        names.add("Грейс");
        names.add("Джейн");
        names.add("Арчи");
        names.add("Блейк");
        names.add("Гамлет");
        names.add("Арчи");
        names.add("Джейн");
        names.add("Декстер");
        names.add("Декстер");
        names.add("Генри");
        names.add("Грейс");
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Stream<String> distinctStream = names.stream().distinct();
        distinctStream.forEach(n-> System.out.println(n));
    }


}
