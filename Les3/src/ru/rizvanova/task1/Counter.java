package ru.rizvanova.task1;

public class Counter  implements AutoCloseable{

    private int counter;
    private boolean isOpen;

    public int getCounter() {
        return counter;
    }

    public boolean isOpen() {
        return isOpen;
    }


    public Counter(){
        isOpen = true;

    }

    public Counter(int counter) {
        isOpen = true;
        this.counter = counter;
    }

    public void add() throws CloseCounterException{
        if (!isOpen)
            throw new CloseCounterException("Счетчик закрыт.");
        counter++;
    }


    @Override
    public void close() {
        isOpen = false;
    }
}
