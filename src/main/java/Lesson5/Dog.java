package Lesson5;

public class Dog extends Animal{

    int runLimit = 500;
    int swimLimit = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int m) {
        System.out.println(getName() + " пробежал " + m + " метров\n");
    }

    @Override
    public void swim(int m) {
        System.out.println(getName() + " проплыл " + m + " метров\n");
    }
}
