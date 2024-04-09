package ru.rizvanova.task3;

public class Item {

    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" +
                "Наименование: '" + name + '\'' +
                ", Цена: " + price +
                ']';
    }

}
