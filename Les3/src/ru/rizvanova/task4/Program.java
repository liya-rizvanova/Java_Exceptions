package ru.rizvanova.task4;

import ru.rizvanova.task4.exceptions.AnimalNameException;
import ru.rizvanova.task4.exceptions.AnimalRunException;
import ru.rizvanova.task4.exceptions.AnimalSwimException;

import java.util.Random;

public class Program {


    /**
     * Задача 4:
     * =========
     * Спроектировать серию классов для работы с животным. Защитить состояние и поведение
     * класса используя исключения.
     */

    public static void main(String[] args) {
        try {

            Cat cat = Cat.create("Персик");
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int j = random.nextInt(2);

                try {
                    switch (j) {
                        case 0 -> cat.swim(i * 10);
                        case 1 -> {
                            cat.run(i * 10);
                            System.out.println("Кот успешно пробежал дистанцию.");
                        }
                    }
                }
                catch (AnimalRunException e){
                    System.out.printf("Исключение при попытке %s пробежать %d метров.\n",
                            e.getName(), e.getDistance());
                }
                catch (AnimalSwimException e){
                    System.out.printf("Исключение при попытке %s проплыть %d метров.\n",
                            e.getName(), e.getDistance());
                }

            }

        } catch (AnimalNameException e) {
            System.out.println(e.getName());
        }
    }

}
