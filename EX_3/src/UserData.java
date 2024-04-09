import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Класс для представления данных о пользователе
public class UserData {
    private String surname;
    private String name;
    private String patronymic;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    // Конструктор для инициализации объекта UserData
    public UserData(String surname, String name, String patronymic, Date birthDate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    // Метод для записи данных в файл
    public void writeToFile() {
        // Используем try-with-resources для автоматического закрытия ресурсов
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
            // Записываем данные в файл
            writer.write(toString());
            writer.newLine();
            // Выводим сообщение об успешной записи данных
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            // В случае ошибки выводим сообщение об ошибке и стектрейс исключения
            System.err.println("Ошибка при записи данных в файл:");
            e.printStackTrace();
        }
    }

    // Переопределение метода toString для записи данных в виде строки
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("%s %s %s %s %d %c", surname, name, patronymic, dateFormat.format(birthDate), phoneNumber, gender);
    }
}
