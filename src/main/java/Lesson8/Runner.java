package Lesson8;

public class Runner {
    public static void main(String[] args) {

        String name1 = "Арчи";
        String phone1 = "+79213698758";

        String name2 = "Арчи";
        String phone2 = "+79213698751";

        String name3 = "Кира";
        String phone3 = "+79301198751";

        String name4 = "Кира";
        String phone4 = "+79301122751";


        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.add(name1,phone1);
        phoneDirectory.add(name2,phone2);
        phoneDirectory.add(name3,phone3);
        phoneDirectory.add(name4,phone4);

//        System.out.println(phoneDirectory.peoplePhonesList);
        phoneDirectory.get(name3);

    }
}
