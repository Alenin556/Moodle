package Lesson5;

public class Cat extends Animal{

    int runLimit = 200;
    int swimLimit = 0;


    // сытость
    boolean full = false;
    int hungryLevel;

    public Cat(String name, int hungryLevel, boolean full) {
        super(name);
        this.hungryLevel = hungryLevel;
        this.full = full;
    }

    public boolean isFull() {
        return full;
    }

    @Override
    public void run(int m) {
        System.out.println(getName() + " пробежал " + m + " метров");
    }

    @Override
    public void swim(int m) {
        System.out.println(getName() + " проплыл " + m + " метров");
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
