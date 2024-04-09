package ru.rizvanova.task4;

import ru.rizvanova.task4.exceptions.AnimalNameException;
import ru.rizvanova.task4.exceptions.AnimalRunException;
import ru.rizvanova.task4.exceptions.AnimalSwimException;

public class Cat extends Animal{

    private Cat(String name) {
        super(name);
    }

    @Override
    void swim(int distance) throws AnimalSwimException {
        throw new AnimalSwimException("Кот не умеет плавать", name, distance);
    }

    @Override
    void run(int distance) throws AnimalRunException {
        if (distance < 3000){
            //TODO: ...
        }
        else {
            throw new AnimalRunException("Котику тяжело бежать", name, distance);

        }
    }

    /**
     * Фабричный метод для создания объекта
     * @param name имя котика
     * @return котик
     * @throws AnimalNameException некорректное имя котика
     */
    public static Cat create(String name) throws AnimalNameException {
        if (name == null || name.length() < 3){
            throw new AnimalNameException("Некорректное имя котика", name);
        }
        return new Cat(name);
    }

}
