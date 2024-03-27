package Lesson5;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(int m){
        System.out.println("Пробежал" + m + "метров");
    }
    public void swim(int m){
        System.out.println("Проплыл" + m + "метров");
    }
}
