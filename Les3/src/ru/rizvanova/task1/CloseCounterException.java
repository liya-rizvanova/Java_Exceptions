package ru.rizvanova.task1;

import java.io.IOException;

public class CloseCounterException extends IOException  {

    public CloseCounterException(String message) {
        super(message);
    }

}
