package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<L extends Fruit> {
    public List<L> getList(){
        return list;
    }

    private List<L> list;
    public Box(L objs) {
        list = new ArrayList<>();
            list.add(objs);

    }


void add(L... objs) {
    for (L obj : objs) {
        list.add(obj);
    }
}
//    void add(Lemon obj) {
//        list.add((L) obj);
//    }
    // Ограничение на тип с помощью wildcard ? super Lemon
    void moveTo(Box<L> box) {
        if (!box.getList().equals(list)) {
            box.getList().addAll(list);
            list.clear();
        }
    }


    // Метод для вычисления общей массы фруктов в коробке
    float getWeight() {
        float weight = 0;
        if (list.isEmpty()) {
            return 0;
        }
        else {
            for (L l : list) {
                weight += l.getWeight();
            }
            return weight;
        }
    }
    boolean compare (Box<?> box){
        return Math.abs(this.getWeight()- box.getWeight()) < 0.001;
    }
    void printBox() {
        int numberOfFruits = list.size();
        if (numberOfFruits > 0) {
            System.out.println("В коробке " + numberOfFruits + " фрукта(ов)");
        } else {
            System.out.println("Коробка пуста");
        }
    }
}
