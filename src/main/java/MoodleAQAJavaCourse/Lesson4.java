public class Lesson4 {

    public static void main(String[] args) {

        Person[] person = new Person[5];
        person[0] = new Person("Alenin Andrew","AQA","","+79315762030",1000000,35);
        person[1] = new Person("Karoeva Katerina","AQA","","+79219304558",500000,40);
        person[2] = new Person("Alexeev Alexey","DEV","","+79814562978",120000,45);
        person[3] = new Person("Alexandrov Alex","AQA","","+78922564815",5000000,56);
        person[4] = new Person("Stepanov Stepan","DEV","","+78114562301",600000,78);

//        if(person[0].age > 40){
//            System.out.println(person[0].getFIO());
//        }

        getNamePersonAgeAbove40(person);
    }

    static class Person{
        String FIO;
        String position;
        String email;
        String phone;
        Integer salary;
        Integer age;

        public Person(String FIO, String position, String email, String phone, Integer salary, Integer age) {
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

        for (Person pers : person){
            if(pers.age > 40){
                name = pers.getFIO();
                System.out.println(name);
            }
        }

//        for (Person pers : person) {
//            if (Arrays.stream(person).allMatch(n -> n.age > 40)) {
//                name = pers.getFIO();
//                System.out.println(name);
//            }
//        }
    }
}
