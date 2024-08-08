package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsHandler {

    public static void main(String[] args) {

        //1. Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.

        List<Integer> randomNumbersList = List.of(1, 2, 3, 4, 4, 8, 10, 11, 12, 14,15,29);
        getCountNumbersDiv2(randomNumbersList);

       //2. Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload». Нужно с ней выполнить следующие манипуляции:
        //2.1. Посчитать, сколько раз объект «High» встречается в коллекции;
        List<String> randomNamesList = List.of("Highload", "High", "Load", "Highload","Road","Yard");

        getCountNameContains(randomNamesList);

        //2.2. Определить, какой элемент в коллекции находится на первом месте. Если мы получили пустую коллекцию, то пусть возвращается 0;
        List<String> randomNamesNull = null;
        findFirstName(randomNamesList);
        findFirstName(randomNamesNull);

        //2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0;
        findLastName(randomNamesList);

        //3. Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4". Необходимо отсортировать строки по возрастанию и добавить их в массив;
        List<String> fNumbersList = List.of("f10", "f15", "f2", "f4","f4");
        sortItems(fNumbersList);

    }

    public static Long getCountNumbersDiv2(List<Integer> numbers){
        long countNumbers = numbers.stream().filter(n -> n % 2 ==0 ).count();
        System.out.println(countNumbers);
        return countNumbers;
    }

    public static Long getCountNameContains(List<String> names){
        Stream <String> highNames = names.stream().filter(n -> n.contains("High"));
        long countNames = highNames.count();
        System.out.println(countNames);
        return countNames;
    }

    public static void findFirstName(List<String> names) {
        List<String> firstName;
        try {
            firstName = names.stream().findFirst().stream().collect(Collectors.toList());
            System.out.println(firstName);
        } catch (NullPointerException nullExc){
            System.out.println(0);;
        }
    }

    public static void findLastName(List<String> names) {
        Stream<String> lastName ;
            names.stream().reduce((first, second) -> second)
                    .orElse(null).lines().forEach(n-> System.out.println(n));
    }

    public static void sortItems(List<String> items){

        List<Integer>numbers = new ArrayList<>();
        for (String number : items) {
            numbers.add(Integer.valueOf(number.substring(1)));
        }

        Stream<Integer> sortedNumbers = numbers.stream().sorted();
        sortedNumbers.map(n->"f" + n).forEach(System.out::println);

    }

}
