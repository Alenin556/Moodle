package Lesson5;

public class FoodOnPlate {

    // уровень еды в тарелке равен 10

    //метод тарелки с едой
    //Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).


    public static void plateOfFood(Cat[] cats, int foodOnPlate) {
        int food;
        for (Cat cat : cats) {
            if (cat.hungryLevel < 5) {
                System.out.println(cat.getName() + " не гоолоден\n");
                cat.setFull(false);
            } else {
                food = foodOnPlate - cat.hungryLevel;
                cat.setFull(true);
                System.out.println("Котик " + cat.getName() + " наелся ? " + cat.full);
                System.out.println("Еды осталось в тарелке : " + food);
                System.out.println("\n");
            }
        }
    }

}
