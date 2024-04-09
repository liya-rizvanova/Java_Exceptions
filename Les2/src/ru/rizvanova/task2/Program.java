package ru.rizvanova.task2;

import java.io.*;
import java.util.*;

public class Program {

    /**
     Задача 3
     ========
     Запишите в файл следующие строки:
     <p>
     Анна=4
     Елена=5
     Марина=6
     Владимир=?
     Константин=?
     Иван=4
     <p>
     Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
     студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
     значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ, отличный от
     числа или ?, бросить подходящее исключение.
     */

    public static void main(String[] args) {
        prepareFile();
        try {
            Map<String, Integer> map = loadFile();
            for (Map.Entry<String, Integer> item : map.entrySet()){
                System.out.printf("%s - %d\n", item.getKey(), item.getValue());
            }
        }
        catch (LoadFileProcessException e){
            System.out.println(e.getMessage());
            System.out.println("Строка: " + e.getLine());
            System.out.println("Ожидалось кол-во символов или знак \"?\", получили: " + e.getData());
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    static Map<String, Integer> loadFile() throws IOException, LoadFileProcessException {
        String line;
        int counter = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("names.txt"))){
            while ((line = bufferedReader.readLine()) != null){
                counter++;
                String[] parts = line.split("=");

                try {
                    map.put(parts[0], parts[1].length() == 1
                            && parts[1].charAt(0) == '?' ? parts[0].length() : Integer.parseInt(parts[1]));
                }
                catch (NumberFormatException e){
                    throw new LoadFileProcessException("Исключение при обработке данных", counter, parts[1]);
                }
            }
        }
        return map;
    }

    private static Random random = new Random();

    static void prepareFile(){

        try (FileWriter fileWriter = new FileWriter("names.txt"))
        {
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=?\n");
            fileWriter.write("Марина=AAAAAAA\n");
            fileWriter.flush();
            /*if (random.nextInt(2) == 0){ //50%
                throw new Exception("Error!");
            }*/
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=4\n");

        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
