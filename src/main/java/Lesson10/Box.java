package Lesson10;


import Lesson10.Fruits.Apple;
import Lesson10.Fruits.Fruit;
import Lesson10.Fruits.Orange;

import java.util.ArrayList;
import java.util.List;

public class Box{

    private Fruit obj;

    public Box(Fruit obj) {
        this.obj = obj;
        box.add(obj);
    }

    public Object getObj() {
        return obj;
    }

    List<Fruit> box = new ArrayList<>();

    public void getBoxInfo(){
        for(Fruit f : box){
            System.out.println(f.getName());
        }
    }

    //TODO получить список элементов коробки
    public List<Fruit> getBoxValues(){
        List<Fruit> list = new ArrayList<>();
        for (Fruit fruit : box){
            list.add(fruit);
        }
        return list;
    }

    //TODO добавить в корзинку фрукт тогда, когда он совпадает по типу
    public void addFruitInBox(Fruit f){
        if(box.get(0).getClass() == f.getClass()){
            box.add(f);
        } else {
            System.out.println("Ошибка");
        }
    }


    //TODO если в коробке тип яблок тогда вес 1.0 если апельсины 1.5
    //TODO взять по объекту из списка определить тип -> приравнять вес -> сумма это количество элементов умноженное на вес
    public float getBoxWeight() {
        float weight = 0;
        int count = 0;
        float weightSum = 0;
        for (Fruit f : box) {
            if (f.getClass() == Apple.class) {
                weight = 1.0f;
                count ++;
            } else  if(f.getClass() == Orange.class){
                weight = 1.5f;
                count ++;
            }
            weightSum = count * weight;
        }
        System.out.println(weightSum);
        return weightSum;
    }


    public boolean compare(Box enterBox){
        if(getBoxWeight() == enterBox.getBoxWeight()){
            return true;
        } else {
            return false;
        }
    }

    public void transfer(Box enterBox){
        List <Fruit> sumFruit = new ArrayList<>();
        List<Fruit> enterFruit = new ArrayList<>();
        if(getClass() == enterBox.getClass()){
           enterFruit = enterBox.getBoxValues();
        }
        for (Fruit f : enterFruit) {
            box.add(f);
        }
    }

}
