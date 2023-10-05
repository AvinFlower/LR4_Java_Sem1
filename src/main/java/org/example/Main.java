package org.example;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("№1");
        Integer[] arr1 = {5, 3, 7, 9, 6 , 1};
        String[] arr2 = {"Груша", "шишка", "фишкка","еклмн", "АБВГД"};
        System.out.println(Arrays.toString(arr1));
        swapElements(arr1, 0,1);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        swapElements(arr2, 3,4);
        System.out.println(Arrays.toString(arr2));

        System.out.println("\n№2");
        List<String> list = convertToList(arr2);
        System.out.println(list);

        System.out.println("\n№3");
        Box<Apple> appleBox1 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());
        Box<Apple> appleBox2 = new Box<>(new Apple());

        orangeBox.add(new Orange());
        appleBox1.add(new Apple());
        appleBox2.add(new Apple());


        // Сравниваем коробки и выводим результат на консоль
        System.out.println("Сравнение коробки яблок и коробки апельсинов: " + appleBox1.compare(orangeBox));
        System.out.println("Сравнение сравнение второй коробки яблок и апельсинов: " + appleBox1.compare(appleBox2));


        // Выводим содержимое коробок до перемещения
        System.out.println("\n\nСодержимое первой коробки с яблоками весом " + appleBox1.getWeight() + "f :");
        appleBox1.printBox();
        appleBox1.getWeight();
        System.out.println("Содержимое второй коробки с яблоками весом " + appleBox2.getWeight() + "f :");
        appleBox2.printBox();

        // Перемещаем яблоки из первой коробки во вторую
        appleBox1.moveTo(appleBox2);

        // Выводим содержимое коробок после перемещения
        System.out.println("\nСодержимое первой коробки с яблоками весом " + appleBox1.getWeight() + "f после перемещения:");
        appleBox1.printBox();

        System.out.println("Содержимое второй коробки с яблоками весом " + appleBox2.getWeight() + "f после перемещения:");
        appleBox2.printBox();


        Box<Lemon> lemonBox1 = new Box<>(new Lemon());
        Box<Lemon> lemonBox2 = new Box<>(new Lemon());

        System.out.println("-------");

        lemonBox1.add(new Lemon(), new Lemon());
//        appleBox1.add(new Lemon());
        lemonBox2.moveTo(lemonBox1);
        lemonBox2.moveTo(lemonBox2);
//        lemonBox2.moveTo(appleBox1);
//        appleBox2.moveTo(lemonBox2);
        lemonBox1.printBox();
        lemonBox2.printBox();
    }
    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static <C> List<C> convertToList(C[] array){
        return Arrays.asList(array);
    }
}