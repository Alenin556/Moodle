package Lesson10.Fruits;

import java.util.Objects;

public class Fruit<T> {
    public String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
