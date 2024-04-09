package ru.rizvanova.task1;

import java.io.IOException;

public class Program {

    /**
     *      Создайте класс Счетчик, у которого есть метод add(), увеличивающий
     *     значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
     *     такого типа можно было работать в блоке try-with-resources. Подумайте, что
     *     должно происходить при закрытии этого ресурса? Напишите метод для
     *     проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого
     *     ресурса, должен выброситься IOException.
     * @param args
     */

    public static void main(String[] args) {

        try(Counter counter = new Counter(12)){
            System.out.printf("Состояние счетчика : %s\n", counter.isOpen() ? "открыт" : "закрыт");
            counter.add();
            counter.close();
            System.out.printf("Текущее состояние счетчика: %d\n", counter.getCounter());
            counter.add();
            System.out.printf("Текущее состояние счетчика: %d\n", counter.getCounter());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
