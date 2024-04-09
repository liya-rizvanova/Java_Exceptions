package ru.rizvanova.task2;

public class LoadFileProcessException extends Exception{

    private final int line;

    private final String data;

    public int getLine() {
        return line;
    }

    public String getData() {
        return data;
    }

    public LoadFileProcessException(String message, int line, String data) {
        super(message);
        this.line = line;
        this.data = data;
    }

}