/*Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива

Метод divisionByZero - Деление на 0

Метод numberFormatException - Ошибка преобразования строки в число

Важно: они не должны принимать никаких аргументов */
package ru.rizvanova.exc1;

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] array = new int[5];
        // Пытаемся обратиться к элементу за пределами массива
        int element = array[10];
    }

    public static void divisionByZero() {
        int a = 10;
        int b = 0;
        // Пытаемся выполнить деление на ноль
        int result = a / b;
    }

    public static void numberFormatException() {
        String str = "abc";
        // Пытаемся преобразовать строку в число, которое не может быть преобразовано
        int num = Integer.parseInt(str);
    }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
