import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        //System.out.printf("Размерность массива: %d\n", task1(new int[] {5, -5, 6}));
        //task2();
        //task3();
        //task4();
        task5();
    }

    /**
     Задача 1
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     Если длина массива меньше некоторого заданного минимума, метод возвращает
     -1, в качестве кода ошибки, иначе - длину массива.
     */

    static int task1(int[] arr){
        if (arr == null){
            return -2;
        }
        if (arr.length == 0){
            return -1;
        }
        return arr.length;
    }

    /**
     Задача 2
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве
     кода ошибки.
     2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     3. если вместо массива пришел null, метод вернет -3
     4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
     Напишите метод, в котором реализуйте взаимодействие с пользователем.
     То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     обработает возвращенное значение и покажет читаемый результат пользователю.
     Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static void task2(){
        while (true){
            System.out.print("Укажите значение для поиска: ");
            int searchNumber = Integer.parseInt(scanner.nextLine());
            int[] array = new int[random.nextInt(1, 6)];
            if (random.nextInt(3) == 0) // 33%
            {
                array = null;
            }
            if (array != null){
                for (int i = 0; i < array.length; i++){
                    array[i] = random.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }

            int codeResult = processArray(array, searchNumber);
            switch (codeResult){
                case -1 -> System.out.println("Размерность массива менее трех символов");
                case -2 -> System.out.println("Элемент не найден");
                case -3 -> System.out.println("Массив некорректно проинициализирован");
                default -> {
                    System.out.println("Массив успешно обработан,завершение работы приложения.");
                    System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                    return;
                }
            }
        }
    }

    /**
     *  -1 => Размерность массива менее трех символов
     * @param array
     * @param searchElement
     * @return
     */
    static int processArray(int[] array, int searchElement){
        if (array == null){
            return -3; // Массив некорректно проинициализирован
        }
        if (array.length < 3){
            return -1; // Размерность массива менее трех символов
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] == searchElement)
                return i;
        }
        return -2; // Элемент не найден
    }

    /**
     Задача 3
     ========
     Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     Необходимо посчитать и вернуть сумму элементов этого массива.
     При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение -1 или 1.
     Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибки.
     */

    static void task3(){
        for (int i = 0; i < 5; i++){
            processArray(generateArray());
        }
    }

    static int[][] generateArray(){
        int[][] array = new int[random.nextInt(4, 6)][5]; // 50%
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                array[i][j] = random.nextInt(-1, 2);
            }
        }
        if (random.nextInt(3) == 0) //33%
        {
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = 2;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    static void processArray(int[][] array){
        if (array.length != array[0].length){
            throw new RuntimeException(String.format("Некорректная размерность массива,\nожидали квадратный массив, получили %dx%d",
                    array.length, array[0].length));
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != -1 && array[i][j] != 0 && array[i][j] != 1) {
                    throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]",
                            i, j));
                }
                else {
                    sum += array[i][j];
                }

            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    /**
     Задача 4
     ========
     Переработать реализацию задачи 3 с использованием кодов ошибок
     */

    static void task4(){
        for (int i = 0; i < 5; i++){
            int errorCode = processArrayV2(generateArray());
            switch (errorCode){
                case -1 -> System.out.println("Некорректный размер массива.");
                case -2 -> System.out.println("Некорректное значение элемента массива.");
                default -> {
                    System.out.printf("Сумма элементов массива: %d\n", errorCode);
                }
            }
        }
    }

    /**
     *
     * @param array
     * @return
     */
    static int processArrayV2(int[][] array){
        if (array.length != array[0].length){
            //throw new RuntimeException(String.format("Некорректная размерность массива,\nожидали квадратный массив, получили %dx%d",
            //        array.length, array[0].length));
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) {
                    //throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]",
                    //        i, j));
                    return -2;
                }
                else {
                    sum += array[i][j];
                }

            }
        }
        return sum;
        //System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    /**
     Задача 5
     ========
     Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
     входящих массивов в той же ячейке.
     Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */


    static int[] generateArrayV2(){
        int[] array = new int[random.nextInt(4, 6)]; // 50%
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(-9, 10);
        }
        if (random.nextInt(3) == 0) //33%
        {
            array = null;
        }
        if (array != null){
            for (int i = 0; i < array.length; i++){
                System.out.printf("%d ", array[i]);
            }
            System.out.println();
        }
        return array;
    }

    static void task5()
    {
        for (int i = 0; i < 5; i++){
            try
            {
                int[] array = getSumArray(generateArrayV2(), generateArrayV2());
                for (int e : array){
                    System.out.printf("%d\t", e);
                }
                System.out.println();
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            catch(CustomArraySizeException e){
                System.out.println(e.getMessage());
                System.out.println("Размерность первого массива: " + e.getLength1());
                System.out.println("Размерность второго массива: " + e.getLength2());
            }
        }
    }


    /**
     * Позволяет склеить два массива в один
     * @param array1 первый массив
     * @param array2 второй массив
     * @return результирующий массив
     * @throws IllegalArgumentException один из массивов проинициализирован некорректно
     * @throws CustomArraySizeException оба массива должны иметь одинаковую размерность
     */
    static int[] getSumArray(int[] array1, int[] array2){
        if (array1 == null || array2 == null){
            throw new IllegalArgumentException("Оба массива должны существовать.");
        }
        if (array1.length != array2.length){
            throw new CustomArraySizeException("Кол-во элементов массивов должно быть одинаковым",
                    array1.length, array2.length);
        }
        int[] res = new int[array1.length];
        for (int i = 0; i < array1.length; i++){
            res[i] = array1[i] + array2[i];
        }
        return res;
    }




}
