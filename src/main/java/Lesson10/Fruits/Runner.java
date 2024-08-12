package Lesson10.Fruits;

import Lesson10.Box;

public class Runner {

    public static void main(String[] args) {

        //1. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

        //2. Класс Box, в который можно складывать фрукты. Коробки сортируются по типу фрукта,
        //  в одну коробку нельзя сложить и яблоки, и апельсины;

        //3. Для хранения фруктов внутри коробки можно использовать ArrayList;

        Apple appleFruit1 = new Apple("я1");
        Apple appleFruit2 = new Apple("я2");

        Orange orangeFruit1 = new Orange("a1");
        Orange orangeFruit2 = new Orange("a2");


        Box applesBox = new Box(appleFruit1);

        Box orangeBox = new Box(orangeFruit1);

        System.out.println(applesBox.getObj());
        System.out.println(orangeBox.getObj());

        //TODO сложить фрукты в корзину
        applesBox.addFruitInBox(appleFruit2);
        orangeBox.addFruitInBox(orangeFruit2);
        applesBox.getBoxInfo();
        orangeBox.getBoxInfo();


        System.out.println("_______________________________");

        Box box1 = new Box(appleFruit1);
        box1.addFruitInBox(appleFruit2);

        box1.getBoxInfo();

        //TODO получить вес корзинки
        box1.getBoxWeight();

        //TODO нельзя положить фрукты разных типов
        box1.addFruitInBox(orangeFruit1);

        //TODO Сравнить вес коробок
        Box box2 = new Box(orangeFruit1);
        box2.addFruitInBox(orangeFruit2);
        box2.addFruitInBox(appleFruit1);

        Boolean falseValue = box2.compare(box1);
        System.out.println(falseValue);

        //TODO пересыпать фрукты в коробку если сходятся по типу

        Apple appleFruit3 = new Apple("я3");
        Apple appleFruit4 = new Apple("я4");

        Box box3 = new Box(appleFruit3);
        box3.addFruitInBox(appleFruit4);

        box1.transfer(box3);
        box1.getBoxInfo();
        box1.getBoxWeight();

    }

}
