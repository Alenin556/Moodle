package Lesson5;

import static Lesson5.FoodOnPlate.plateOfFood;

public class Runner {
    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        dogBobik.run(150);

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Милаш",4,false);
        cats[1] = new Cat("Муся",5,false);
        cats[2] = new Cat("Мила",10,false);
        cats[3] = new Cat("Кира",40,false);

        plateOfFood(cats,100);
    }
}
