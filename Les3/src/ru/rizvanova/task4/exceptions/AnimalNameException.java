package ru.rizvanova.task4.exceptions;

public class AnimalNameException extends AnimalException {

    private final String name;

    public String getName() {
        return name;
    }

    public AnimalNameException(String message, String name) {
        super(message);
        this.name = name;
    }

}
