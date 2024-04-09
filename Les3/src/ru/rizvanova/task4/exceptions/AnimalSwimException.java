package ru.rizvanova.task4.exceptions;

public class AnimalSwimException extends AnimalActionException{

    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}
