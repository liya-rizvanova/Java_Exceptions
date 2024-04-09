package ru.rizvanova.task3;

public class Customer {

    private String name;
    private int age;
    private String phone;

    public Customer(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[" +
                "Имя: '" + name + '\'' +
                ", Возраст: " + age +
                ", Телефон: '" + phone + '\'' +
                ']';
    }

}
