import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Запрос данных у пользователя
            System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол(f/m):");
            String input = scanner.nextLine();

            // Разделение введенной строки на отдельные данные
            String[] data = input.split(" ");

            // Проверка количества введенных данных
            if (data.length != 6) {
                throw new DataFormatException("Неверное количество данных.");
            }

            // Извлечение данных из массива
            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];

            // Парсинг даты рождения
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date birthDate;
            try {
                birthDate = dateFormat.parse(data[3]);
            } catch (ParseException e) {
                throw new DataFormatException("Неверный формат даты рождения.");
            }

            // Парсинг номера телефона
            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(data[4]);
            } catch (NumberFormatException e) {
                throw new DataFormatException("Неверный формат номера телефона.");
            }

            // Проверка правильности ввода пола
            char gender;
            if (data[5].length() != 1 || (!data[5].equals("f") && !data[5].equals("m"))) {
                throw new DataFormatException("Неверный формат пола.");
            } else {
                gender = data[5].charAt(0);
            }

            // Создание объекта UserData
            UserData userData = new UserData(surname, name, patronymic, birthDate, phoneNumber, gender);

            // Запись данных в файл
            userData.writeToFile();

        } catch (DataFormatException e) {
            // В случае ошибки выводим сообщение об ошибке
            System.err.println("Ошибка: " + e.getMessage());
            // Пользователь должен увидеть стектрейс ошибки
            e.printStackTrace();
        } finally {
            // Закрытие сканнера
            scanner.close();
        }
    }
}
