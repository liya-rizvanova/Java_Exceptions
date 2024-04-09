package ru.rizvanova.task4;

import ru.rizvanova.task4.exceptions.AnimalRunException;
import ru.rizvanova.task4.exceptions.AnimalSwimException;

public abstract class Animal {

    protected final String name;

    public Animal(String name) {

        this.name = name;
    }

    abstract void swim(int distance) throws AnimalSwimException;

    abstract void run(int distance) throws AnimalRunException;


}
